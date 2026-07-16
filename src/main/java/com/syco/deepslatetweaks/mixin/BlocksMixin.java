package com.syco.deepslatetweaks.mixin;

import net.minecraft.world.level.block.Blocks;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;

import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

/**
 * Intercepts the strength(hardness, resistance) builder call of each targeted block inside
 * Blocks.<clinit>.
 *
 * Since Minecraft 26.2, registry-name string constants no longer appear in Blocks.<clinit>
 * (registration goes through BlockItemIds ResourceKey constants), so each slice is anchored
 * between the GETSTATIC of the block's BlockItemIds key (start of its registration) and the
 * PUTSTATIC of its Blocks field (end of its registration). Opcodes are pinned because Blocks
 * fields are also READ later in <clinit> (e.g. Properties.ofLegacyCopy(DEEPSLATE)).
 *
 * WARNING: an unmatched slice anchor can silently widen the slice instead of erroring (observed
 * on 26.2 with the old string-constant anchors), which makes handlers clobber unrelated blocks.
 * The startup log in DeepslateTweaks prints tweaked values plus vanilla controls to catch this.
 */
@Mixin(Blocks.class)
public class BlocksMixin {

    // Modify Deepslate block strength: 3.0 -> 1.5 (Stone)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateStrength(Args args) {
        args.set(0, 1.5F);
        args.set(1, 6.0F);
    }

    // Modify Cobbled Deepslate block strength: 3.5 -> 2.0 (Cobblestone)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "COBBLED_DEEPSLATE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "COBBLED_DEEPSLATE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyCobbledDeepslateStrength(Args args) {
        args.set(0, 2.0F);
        args.set(1, 6.0F);
    }

    // Modify Deepslate Gold Ore strength: 4.5 -> 3.0 (Gold Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_GOLD_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_GOLD_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateGoldOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Iron Ore strength: 4.5 -> 3.0 (Iron Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_IRON_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_IRON_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateIronOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Coal Ore strength: 4.5 -> 3.0 (Coal Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_COAL_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_COAL_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateCoalOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Lapis Ore strength: 4.5 -> 3.0 (Lapis Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_LAPIS_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_LAPIS_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateLapisOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Diamond Ore strength: 4.5 -> 3.0 (Diamond Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_DIAMOND_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_DIAMOND_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateDiamondOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Redstone Ore strength: 4.5 -> 3.0 (Redstone Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_REDSTONE_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_REDSTONE_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateRedstoneOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Emerald Ore strength: 4.5 -> 3.0 (Emerald Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_EMERALD_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_EMERALD_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateEmeraldOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Modify Deepslate Copper Ore strength: 4.5 -> 3.0 (Copper Ore)
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", opcode = Opcodes.GETSTATIC,
                            target = "Lnet/minecraft/references/BlockItemIds;" +
                                    "DEEPSLATE_COPPER_ORE:Lnet/minecraft/references/BlockItemId;"),
                    to = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC,
                            target = "Lnet/minecraft/world/level/block/Blocks;" +
                                    "DEEPSLATE_COPPER_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateCopperOreStrength(Args args) {
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }
}
