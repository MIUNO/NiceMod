package ru.miuno.nicemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.miuno.nicemod.blocks.NiceBlock;
import ru.miuno.nicemod.blocks.decoration.Weathercock;
import ru.miuno.nicemod.itemgroup.NiceItemGroup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NiceMod implements ModInitializer {

    public static final String MOD_ID = "nicemod";
	public static final Logger LOGGER = LogManager.getLogger("nicemod");
	public static final Block WEATHERCOCK = new Weathercock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK).nonOpaque());
	@Override
	public void onInitialize() {
		NiceBlock.registerModBlocks();
		LOGGER.info("Hello!");
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "weathercock"), WEATHERCOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "weathercock"), new BlockItem(WEATHERCOCK, new FabricItemSettings().group(NiceItemGroup.ITEM_GROUP)));
	}
}
