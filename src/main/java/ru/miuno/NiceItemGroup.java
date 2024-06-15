package ru.miuno;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ru.miuno.blocks.NiceBlock;

public class NiceItemGroup {
	public static final RegistryKey<ItemGroup> NICEMOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(NiceMod.MOD_ID, "niceitemgroup"));

	public static void registerItemGroup(){
        Registry.register(Registries.ITEM_GROUP, NICEMOD, FabricItemGroup.builder()
		.displayName(Text.translatable("itemGroup.nicemod.general"))
		.icon(() -> new ItemStack(NiceBlock.GLOBE))
		.entries((context, entries) -> { }) .build());
    }
}
