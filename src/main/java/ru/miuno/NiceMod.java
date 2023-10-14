package ru.miuno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import ru.miuno.blocks.NiceBlock;

public class NiceMod implements ModInitializer {
	public static final String MOD_ID = "nicemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("nicemod");

	public static final Identifier BELL = new Identifier("nicemod:bell");
	public static SoundEvent BELL_EVENT = SoundEvent.of(BELL);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello!");
		
		NiceBlock.registerModBlocks();
		NiceItemGroup.registerItemGroup();
		Registry.register(Registries.SOUND_EVENT, NiceMod.BELL, BELL_EVENT);
	}
}