package ru.miuno.nicemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.miuno.nicemod.blocks.NiceBlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NiceMod implements ModInitializer {

    public static final String MOD_ID = "nicemod";
	public static final Logger LOGGER = LogManager.getLogger("nicemod");
	
    public static final Identifier BELL = new Identifier("nicemod:bell");
    public static SoundEvent BELL_EVENT = new SoundEvent(BELL);
	
	@Override
	public void onInitialize() {
		NiceBlock.registerModBlocks();
		LOGGER.info("Hello!");

		Registry.register(Registry.SOUND_EVENT, NiceMod.BELL, BELL_EVENT);
	}
 
}
