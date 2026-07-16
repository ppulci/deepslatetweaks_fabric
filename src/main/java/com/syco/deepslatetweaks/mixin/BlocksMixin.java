package com.syco.deepslatetweaks.mixin;

import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;

import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Blocks.class)
public class BlocksMixin {

    // Modify Deepslate block strength
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateStrength(Args args) {
        // Set hardness to 1.5F (like stone) and keep resistance at 6.0F
        args.set(0, 1.5F);
        args.set(1, 6.0F);
    }

    // Modify Cobbled Deepslate block strength
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=cobbled_deepslate"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "COBBLED_DEEPSLATE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyCobbledDeepslateStrength(Args args) {
        // Set hardness to 2.0F (like cobblestone) and keep resistance at 6.0F
        args.set(0, 2.0F);
        args.set(1, 6.0F);
    }

    // Redirect the Deepslate Gold Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_gold_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_GOLD_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateGoldOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Iron Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_iron_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_IRON_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateIronOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Coal Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_coal_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_COAL_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateCoalOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Lapis Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_lapis_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_LAPIS_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateLapisOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Diamond Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_diamond_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_DIAMOND_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateDiamondOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Redstone Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_redstone_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_REDSTONE_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateRedstoneOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }


    // Redirect the Deepslate Emerald Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_emerald_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_EMERALD_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateEmeraldOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

    // Redirect the Deepslate Copper Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_copper_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;" +
                            "DEEPSLATE_COPPER_ORE:Lnet/minecraft/world/level/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(FF)" +
                            "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"
            )
    )
    private static void modifyDeepslateCopperOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }
}