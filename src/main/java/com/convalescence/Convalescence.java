package com.convalescence;

import com.convalescence.spell.Spells;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Convalescence implements ModInitializer {

	public static String MOD_ID = "convalescence";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Convalescence.LOGGER.info("Initializing Convalescence");
		Spells.init();
	}
}