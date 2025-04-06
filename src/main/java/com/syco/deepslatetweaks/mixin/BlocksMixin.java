package com.syco.deepslatetweaks.mixin;

import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin (Blocks.class)
public class BlocksMixin {

    //Redirect the Deepslate registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
            )
    )
    private static void modifyDeepslateStrength(Args args) {
        // cobblestone strength is 1.5f
        args.set(0, 1.5F);
        args.set(1, 6.0F);
    }

    //Redirect the Cobbled Deepslate registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=cobbled_deepslate"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;COBBLED_DEEPSLATE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
            )
    )
    private static void modifyCobbledDeepslateStrength(Args args) {
        // cobblestone strength is 2.0f
        args.set(0, 2.0F);
        args.set(1, 6.0F);
    }

    // Redirect the Deepslate Gold Ore registry
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=deepslate_gold_ore"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_GOLD_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_IRON_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_COAL_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_LAPIS_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_DIAMOND_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_REDSTONE_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_EMERALD_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
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
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DEEPSLATE_COPPER_ORE:Lnet/minecraft/block/Block;")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)" +
                            "Lnet/minecraft/block/AbstractBlock$Settings;"
            )
    )
    private static void modifyDeepslateCopperOreStrength(Args args) {
        // ore strength is 3.0f
        args.set(0, 3.0F);
        args.set(1, 3.0F);
    }

}