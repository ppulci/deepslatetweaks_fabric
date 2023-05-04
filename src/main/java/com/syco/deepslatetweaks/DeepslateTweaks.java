package com.syco.deepslatetweaks;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepslateTweaks implements ModInitializer {

	public static final String MOD_ID = "deepslatetweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Mod Initializations
	@Override
	public void onInitialize() {
		LOGGER.info("Loading Deepslate Tweaks!");
	}
}
