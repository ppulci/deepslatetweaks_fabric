# Deepslate Tweaks *(Fabric repo)*

Deepslate Tweaks lowers the strength of Deepslate to match Stone, restoring the classic mining pace deep underground. Since its introduction, Deepslate has been noticeably slower to mine than Stone — not enough to be interesting, just enough to be a time sink. Multiplied across the thousands of blocks a player mines below Y=0, that lost time adds up and gets in the way of the gameplay that's actually fun. This mod gives players that time back.

![Demo](https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExOGducWYzaDN3bjhyMzZtd2U3MWhiNjZsb3Vrb2tubnYxMGJ5ZnV0bSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/eCp73D7FMXpjzPaPCF/giphy.gif)

**Available on CurseForge or Modrinth! Download by clicking below!**

[![CurseForge Downloads](https://cf.way2muchnoise.eu/full_632466_downloads.svg?badge_style=for_the_badge)](https://www.curseforge.com/minecraft/mc-mods/deepslate-tweaks)
[![Downloads](https://img.shields.io/modrinth/dt/Jc0FvX5i?logo=modrinth&style=for-the-badge&logoColor=4c1&labelColor=2D2D2D)](https://modrinth.com/project/Jc0FvX5i)

## What it changes

| Block | Vanilla hardness | New hardness | Matches |
|---|---|---|---|
| Deepslate | 3.0 | 1.5 | Stone |
| Cobbled Deepslate | 3.5 | 2.0 | Cobblestone |
| Deepslate Coal Ore | 4.5 | 3.0 | Coal Ore |
| Deepslate Iron Ore | 4.5 | 3.0 | Iron Ore |
| Deepslate Copper Ore | 4.5 | 3.0 | Copper Ore |
| Deepslate Gold Ore | 4.5 | 3.0 | Gold Ore |
| Deepslate Lapis Ore | 4.5 | 3.0 | Lapis Ore |
| Deepslate Redstone Ore | 4.5 | 3.0 | Redstone Ore |
| Deepslate Diamond Ore | 4.5 | 3.0 | Diamond Ore |
| Deepslate Emerald Ore | 4.5 | 3.0 | Emerald Ore |

Blast resistance is unchanged for Deepslate and Cobbled Deepslate; ore variants use the same 3.0/3.0 strength as their surface counterparts.

## How it works

The mod applies a single [Mixin](https://github.com/SpongePowered/Mixin) to `net.minecraft.world.level.block.Blocks` that intercepts each block's `strength(...)` builder call during class initialization and swaps in the new values. No blocks are replaced or re-registered, so the change is invisible to other mods and datapacks — Deepslate is still Deepslate, it just breaks faster.

Because only block properties are modified, the mod is:

- **Server-side friendly** — install it on a server and vanilla-adjacent clients will still see correct break speeds (block breaking is server-authoritative).
- **Safe to add or remove** at any time; it stores nothing in the world.

## Compatibility

- **Minecraft:** 26.1.2 (on Fabric Loader 0.19.3; see earlier releases for 1.21.x versions)
- **Mod loader:** Fabric (this repo is Fabric-only; Forge and NeoForge live in separate repos) — requires [Fabric API](https://modrinth.com/mod/fabric-api)

## Building from source

```
./gradlew build
```

The built jar is written to `build/libs/`. Java 25 is required.

## License

All Rights Reserved.
