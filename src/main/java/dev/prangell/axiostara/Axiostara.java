package dev.prangell.axiostara;

import dev.prangell.axiostara.config.AxiostaraConfig;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Axiostara implements ModInitializer {
	public static final String MOD_ID = "axiostara";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, AxiostaraConfig.class);
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}