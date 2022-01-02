package ru.miuno.nicemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import ru.miuno.nicemod.blocks.NiceBlock;

public class NiceClient implements ClientModInitializer  {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), NiceBlock.WEATHERCOCK, NiceBlock.WALLLANTERN, NiceBlock.WALLLANTERNA, NiceBlock.WINDOW);
	}
}