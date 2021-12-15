package ru.miuno.nicemod;

import net.fabricmc.api.ModInitializer;
import ru.miuno.nicemod.blocks.NiceBlock;

public class NiceMod implements ModInitializer {

    public static final String MOD_ID = "nicemod";

	@Override
	public void onInitialize() {
		NiceBlock.registerModBlocks();
		
	}
}
