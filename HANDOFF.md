# HANDOFF — Deepslate Tweaks (Fabric)

Orientation document for future agents/developers working on this repo. Read this alongside `README.md` (player-facing description) before making changes. This is the **Fabric** repo; the Forge and NeoForge ports live in separate repos and must stay content-identical (see versioning below).

## What this mod does

Lowers the hardness of Deepslate, Cobbled Deepslate, and all eight deepslate ore variants to match their Stone-world counterparts, so mining below Y=0 feels like classic pre-1.17 mining. Nothing else — no new blocks, items, config, or world data.

## Repo layout

| Path | Purpose |
|---|---|
| `src/main/java/com/syco/deepslatetweaks/DeepslateTweaks.java` | Mod entrypoint (`ModInitializer`). Logs the effective hardness of deepslate/cobbled/iron-ore on load (expected 1.5/2.0/3.0 — vanilla values mean the mixin broke) plus controls stone/dirt (must stay 1.5/0.5 — anything else means the mixin over-applied); all real behavior lives in the mixin. |
| `src/main/java/com/syco/deepslatetweaks/mixin/BlocksMixin.java` | The entire implementation — 10 `@ModifyArgs` injections into `Blocks.<clinit>`. Loader-agnostic; kept identical to the Forge/NeoForge repos for the same MC version. |
| `src/main/resources/deepslatetweaks.mixins.json` | Mixin config. Registered ONE way, same in dev and production: the `"mixins"` array in `fabric.mod.json` (no manifest attribute, no program args — Fabric is simpler than Forge here). No `refmap` — the game is unobfuscated since 26.1 and Fabric's intermediary is a stub (`0.0.0`); never re-add one. |
| `src/client/java/.../DeepslateTweaksClient.java` | Empty `ClientModInitializer` (required by the `client` entrypoint in `fabric.mod.json`). The template client mixin was deleted at the 26.1.2 port — it was dead boilerplate targeting a yarn-named class. |
| `src/main/resources/fabric.mod.json` | Mod metadata. `${version}` is expanded by `processResources`; the packaged copy must have no unexpanded placeholders. |
| `gradle.properties` | Single source of truth for MC/loader/Fabric-API versions and mod version. (`yarn_mappings` was removed at the 26.1.2 port — yarn does not exist for 26.x, official names ship unobfuscated.) |
| `build.gradle` | Fabric Loom setup. Plugin id is `net.fabricmc.fabric-loom` since 26.x (was `fabric-loom-remap` on 1.21.x); no `mappings` line; loader/API use plain `implementation`, not `modImplementation`. Output jar: `deepslatetweaks-fabric-<minecraft_version>-<mod_version>` (set in the `base` block). |
| `settings.gradle` | Adds the foojay toolchain resolver so Gradle auto-provisions the Java 25 JDK declared in `build.gradle`. |

## How the implementation works (and why)

All vanilla blocks are constructed in the static initializer of `net.minecraft.world.level.block.Blocks`. Each registration passes a `BlockBehaviour.Properties` builder, and hardness/resistance are set via `Properties.strength(float, float)`.

`BlocksMixin` uses `@ModifyArgs` targeting `strength(FF)` inside `<clinit>`, with a **`@Slice` per block** to pick out the right call among the hundreds in that initializer:

- `from` anchors on the block's registry-name string constant (e.g. `"deepslate"`), which begins that block's registration. **This works on MC 26.1.x but NOT on 26.2+** — 26.2 removed those strings from `Blocks.<clinit>`; when porting to 26.2+, copy the Forge/NeoForge repos' `BlocksMixin` (anchors on `BlockItemIds` `GETSTATIC` with pinned opcodes; same package, drop-in).
- `to` anchors on the `PUTSTATIC`-written `Blocks` field (e.g. `Blocks.DEEPSLATE`), which ends that block's registration.
- The single `strength(FF)` call between those two anchors is the one modified.

This approach was chosen over alternatives because:

- **No block replacement**: the block instances are unchanged, so registry IDs, tags, loot tables, and other mods' references are unaffected. The mod is invisible except for break speed.
- **Server-side effective**: break speed is server-authoritative, so the mod works on a server even if clients don't have it.

Values applied (vanilla → modded hardness): Deepslate 3.0 → 1.5 (Stone), Cobbled Deepslate 3.5 → 2.0 (Cobblestone), all deepslate ores 4.5 → 3.0 (surface ores). Resistance args are also set but to their existing vanilla values (6.0 for deepslate/cobbled, 3.0 for ores), so effectively unchanged.

## Known concerns / fragility

0. **Unmatched slice anchors fail SILENTLY, not loudly.** Observed on the NeoForge 26.2 port: when a `from` anchor stops matching, the slice silently widens to the start of `<clinit>` instead of erroring — handlers clobber unrelated blocks (stone, dirt, ...), nothing crashes, and `defaultRequire: 1` is satisfied because each handler still matches ≥1 instruction. Only the startup self-check log exposes it. This is why the self-check line includes vanilla CONTROL blocks (stone 1.5, dirt 0.5) — check it after every port.
1. **Slice anchors are version-fragile.** `defaultRequire: 1` + `"required": true` in `deepslatetweaks.mixins.json` are the safety net: **if an injection fails to apply, the game crashes at startup rather than silently shipping vanilla values.** That's intentional — keep them.
2. **Per-version updates are expected work.** Procedure: bump `minecraft_version`, `loader_version`, `fabric_api_version` in `gradle.properties` (check https://fabricmc.net/develop and meta.fabricmc.net), `gradlew runClient`, and check the "Effective hardness" line (1.5/2.0/3.0 + controls 1.5/0.5 = working). The full gated procedure lives in the `update-deepslate-tweaks-mod` skill (Fabric section).
3. **Duplicated boilerplate.** Ten nearly identical `@ModifyArgs` methods differing only in anchor strings and values. Mixin annotations require compile-time constants, so this can't be trivially looped.
4. **Values are hardcoded** — no config.
5. **Hard dependency on Fabric API** (`"fabric-api": "*"` in `fabric.mod.json`), inherited from the mod template. Nothing in the code actually uses it — dropping it is a possible cleanup, but it changes the user-facing install requirements, so treat it as a scope decision.

## Untouched blocks (possible scope questions)

The mod deliberately covers only the blocks players mass-mine while caving. Not covered: polished deepslate, deepslate bricks/tiles (and their stairs/slabs/walls), chiseled/cracked variants, infested deepslate, and reinforced deepslate. Crafted/decorative variants arguably *should* keep their vanilla strength; if a user requests parity there, treat it as a scope decision, not an oversight.

## Verifying the built jar works OUTSIDE the dev environment

History lesson (from this mod's past): a release once shipped with mixins that worked in dev but silently did nothing in production. Fabric has less dev/prod divergence than Forge (the mixin config is registered the same way in both), but packaging bugs are still only caught by testing the shipped jar. Never trust `runClient` alone.

**Checks on every built jar** (`build/libs/`):
1. `deepslatetweaks.mixins.json` present at the jar root.
2. `fabric.mod.json` declares it in the `"mixins"` array.
3. Packaged `fabric.mod.json` has no unexpanded `${...}` placeholders.

**Production smoke-test procedure (headless, ~5 min, no manual play needed):**

1. Download the fabric-installer jar (latest stable from `https://meta.fabricmc.net/v2/versions/installer`).
2. `java -jar fabric-installer-<ver>.jar server -dir <empty dir> -mcversion <mc> -loader <loader> -downloadMinecraft` (a Gradle-provisioned JDK works: `%USERPROFILE%\.gradle\jdks\...`).
3. Copy the built jar from `build/libs/` into `<dir>/mods/` — **plus a matching Fabric API jar** (hard dependency; download from Modrinth), or the server refuses to start with `Incompatible mods found!`.
4. Write `eula=true` to `<dir>/eula.txt`; from `<dir>`: `java -Xmx2G -jar fabric-server-launch.jar --nogui`.
5. Watch the log for the "Effective hardness" line with modded values AND `Done (...s)!`. Vanilla values (3.0/3.5/4.5) in that line = mixin not applied in production. A block-hardness mod is fully verifiable on a dedicated server because breaking speed is server-authoritative.

## Release notes / publishing

- Published on CurseForge (project 632466) and Modrinth (project `Jc0FvX5i`); links/badges in `README.md`.
- **Versioning convention (applies across the NeoForge/Forge/Fabric repos):** `mod_version` tracks CONTENT only and must be identical across every loader and game version shipping that content. Never bump it for a port — game version and loader are carried by the filename (`archivesName` includes `minecraft_version`) and platform metadata. Bump MINOR for new user-facing capability, PATCH for bugfixes, MAJOR for gameplay redesign; a content bump means coordinated releases in all loader repos.
- Current version: 2.2.0 (self-check startup diagnostics — content parity with the Forge/NeoForge repos' 2.2.0). Shipped here for MC 26.1.2 on Fabric Loader 0.19.3.
- Build with `gradlew build`; jar lands in `build/libs/`. Java 25 required (Gradle provisions it via the foojay toolchain resolver).
- License is All Rights Reserved.
