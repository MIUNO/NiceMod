package ru.miuno.nicemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class NiceClient implements ClientModInitializer  {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(NiceMod.WEATHERCOCK, RenderLayer.getCutout());
	}
}