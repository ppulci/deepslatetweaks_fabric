package com.syco.deepslatetweaks.mixin;

import net.minecraft.block.*;
import net.minecraft.block.Blocks;
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
        return new Block(settings.strength(1.5f, 6.0f));
    }
}
