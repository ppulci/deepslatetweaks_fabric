package com.syco.deepslatetweaks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepslateTweaks implements ModInitializer {

	public static final String MOD_ID = "deepslatetweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Mod Initializations
	@Override
	public void onInitialize() {
		// Startup self-check: vanilla values here mean the mixin did not apply; wrong control
		// values mean a slice anchor widened and clobbered unrelated blocks.
		LOGGER.info("Effective hardness — deepslate: {}, cobbled: {}, deepslate iron ore: {} (expected 1.5/2.0/3.0); controls — stone: {}, dirt: {} (expected 1.5/0.5)",
				Blocks.DEEPSLATE.defaultDestroyTime(),
				Blocks.COBBLED_DEEPSLATE.defaultDestroyTime(),
				Blocks.DEEPSLATE_IRON_ORE.defaultDestroyTime(),
				Blocks.STONE.defaultDestroyTime(),
				Blocks.DIRT.defaultDestroyTime());
	}
}
