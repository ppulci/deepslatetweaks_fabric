package com.syco.deepslatetweaks.mixin;

import net.minecraft.block.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin (Blocks.class)
public class BlocksMixin {

    //Redirect the Deepslate registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=deepslate"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/PillarBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static PillarBlock DeepslateRedirect(AbstractBlock.Settings settings) {
        // stone strength is 1.5f
        return new PillarBlock(settings.strength(1.5f, 6.0f));
    }

    //Redirect the Cobbled Deepslate registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=cobbled_deepslate"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/Block;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static Block CobbledDeepslateRedirect(AbstractBlock.Settings settings) {
        // cobblestone strength is 2.0f
        return new Block(settings.strength(2.0f, 6.0f));
    }

    // Redirect the Deepslate Gold Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_gold_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")
    
    private static ExperienceDroppingBlock DeepslateGoldOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(experience, settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Iron Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_iron_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateIronOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(ConstantIntProvider.create(0), settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Coal Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_coal_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateCoalOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Lapis Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_lapis_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateLapisOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Diamond Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_diamond_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateDiamondOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Redstone Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_redstone_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/RedstoneOreBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static RedstoneOreBlock DeepslateRedstoneOreRedirect(AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new RedstoneOreBlock(settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Emerald Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_emerald_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateEmeraldOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings.strength(3.0f, 3.0f));
    }

    // Redirect the Deepslate Copper Ore registry
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = {
                                    "stringValue=deepslate_copper_ore"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/ExperienceDroppingBlock;*",
                    ordinal = 0
            ),
            method = "<clinit>")

    private static ExperienceDroppingBlock DeepslateCopperOreRedirect(IntProvider experience, AbstractBlock.Settings settings) {
        // ore strength is 3.0f
        return new ExperienceDroppingBlock(ConstantIntProvider.create(0), settings.strength(3.0f, 3.0f));
    }

}