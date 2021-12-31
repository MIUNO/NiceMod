package ru.miuno.nicemod.itemgroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import ru.miuno.nicemod.blocks.NiceBlock;

public class NiceItemGroup {

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("nicemod", "general"),
		() -> new ItemStack(NiceBlock.WEATHERCOCK)); {
			
		}
}