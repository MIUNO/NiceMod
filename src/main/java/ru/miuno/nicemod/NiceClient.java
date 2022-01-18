package ru.miuno.nicemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import ru.miuno.nicemod.blocks.NiceBlock;

public class NiceClient implements ClientModInitializer  {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
		NiceBlock.OAK_WALLLANTERN, NiceBlock.OAK_WALLLANTERNA, NiceBlock.OAK_WINDOW, NiceBlock.OAK_DECORE1, 
		NiceBlock.SPRUCE_WALLLANTERN, NiceBlock.SPRUCE_WALLLANTERNA, NiceBlock.SPRUCE_WINDOW, NiceBlock.SPRUCE_DECORE1,
		NiceBlock.WEATHERCOCK,
		NiceBlock.FLOWERBED_ROSE_BUSH, NiceBlock.FLOWERBED_PEONY, NiceBlock.FLOWERBED_LILAC, NiceBlock.FLOWERBED_BLUE_ORCHID, NiceBlock.FLOWERBED_RED_TULIP, NiceBlock.FLOWERBED_DANDELION, NiceBlock.FLOWERBED_OXEYE_DAISY);
	}
}