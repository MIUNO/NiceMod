package ru.miuno.nicemod;

import net.fabricmc.api.ModInitializer;
import ru.miuno.nicemod.blocks.NiceBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NiceMod implements ModInitializer {

    public static final String MOD_ID = "nicemod";
	public static final Logger LOGGER = LogManager.getLogger("nicemod");

	@Override
	public void onInitialize() {
		NiceBlock.registerModBlocks();
		LOGGER.info("Hello!");
		
	}
}
