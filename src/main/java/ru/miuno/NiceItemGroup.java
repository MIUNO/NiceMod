package ru.miuno;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import ru.miuno.blocks.NiceBlock;

public class NiceItemGroup {
    public static final ItemGroup NICEMOD = FabricItemGroup.builder()
	.icon(() -> new ItemStack(NiceBlock.GLOBE))
	.displayName(Text.translatable("itemGroup.nicemod.general"))
        .entries((context, entries) -> {
	//  Blocks
		// Cobblestone
		entries.add(NiceBlock.COBBLESTONE_BASIS);
		entries.add(NiceBlock.COBBLESTONE_COLUMN);
		entries.add(NiceBlock.COBBLESTONE_CAPITAL);
		entries.add(NiceBlock.COBBLESTONE_HOLE);
		entries.add(NiceBlock.COBBLESTONE_RECESS);
		entries.add(NiceBlock.COBBLESTONE_RECESS_A);
		entries.add(NiceBlock.COBBLESTONE_SLABHOLE);
		entries.add(NiceBlock.COBBLESTONE_SLABRECESS);
		entries.add(NiceBlock.COBBLESTONE_SLABRECESS_A);
		entries.add(NiceBlock.COBBLESTONE_DEEPENING);
		entries.add(NiceBlock.COBBLESTONE_LOOPHOLE);
		entries.add(NiceBlock.COBBLESTONE_SLABLOOPHOLE);
		entries.add(NiceBlock.COBBLESTONE_WALLPIPE);
		// Cobbled deepslate
		entries.add(NiceBlock.COBBLED_DEEPSLATE_BASIS);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_COLUMN);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_CAPITAL);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_HOLE);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_RECESS);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_RECESS_A);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_SLABHOLE);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_SLABRECESS);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_SLABRECESS_A);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_DEEPENING);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_LOOPHOLE);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_SLABLOOPHOLE);
		entries.add(NiceBlock.COBBLED_DEEPSLATE_WALLPIPE);
		// Stone
		entries.add(NiceBlock.STONE_BASIS);
		entries.add(NiceBlock.STONE_COLUMN);
		entries.add(NiceBlock.STONE_CAPITAL);
		entries.add(NiceBlock.STONE_HOLE);
		entries.add(NiceBlock.STONE_RECESS);
		entries.add(NiceBlock.STONE_RECESS_A);
		entries.add(NiceBlock.STONE_SLABHOLE);
		entries.add(NiceBlock.STONE_SLABRECESS);
		entries.add(NiceBlock.STONE_SLABRECESS_A);
		entries.add(NiceBlock.STONE_DEEPENING);
		entries.add(NiceBlock.STONE_LOOPHOLE);
		entries.add(NiceBlock.STONE_SLABLOOPHOLE);
		entries.add(NiceBlock.STONE_WALLPIPE);
		// Stone Bricks
		entries.add(NiceBlock.STONE_BRICK_BASIS);
		entries.add(NiceBlock.STONE_BRICK_COLUMN);
		entries.add(NiceBlock.STONE_BRICK_CAPITAL);
		entries.add(NiceBlock.STONE_BRICK_HOLE);
		entries.add(NiceBlock.STONE_BRICK_RECESS);
		entries.add(NiceBlock.STONE_BRICK_RECESS_A);
		entries.add(NiceBlock.STONE_BRICK_SLABHOLE);
		entries.add(NiceBlock.STONE_BRICK_SLABRECESS);
		entries.add(NiceBlock.STONE_BRICK_SLABRECESS_A);
		entries.add(NiceBlock.STONE_BRICK_DEEPENING);
		entries.add(NiceBlock.STONE_BRICK_LOOPHOLE);
		entries.add(NiceBlock.STONE_BRICK_SLABLOOPHOLE);
		entries.add(NiceBlock.STONE_BRICK_WALLPIPE);
		// Sandstone
		entries.add(NiceBlock.SANDSTONE_BASIS);
		entries.add(NiceBlock.SANDSTONE_COLUMN);
		entries.add(NiceBlock.SANDSTONE_CAPITAL);
		entries.add(NiceBlock.SANDSTONE_HOLE);
		entries.add(NiceBlock.SANDSTONE_RECESS);
		entries.add(NiceBlock.SANDSTONE_RECESS_A);
		entries.add(NiceBlock.SANDSTONE_SLABHOLE);
		entries.add(NiceBlock.SANDSTONE_SLABRECESS);
		entries.add(NiceBlock.SANDSTONE_SLABRECESS_A);
		entries.add(NiceBlock.SANDSTONE_DEEPENING);
		entries.add(NiceBlock.SANDSTONE_LOOPHOLE);
		entries.add(NiceBlock.SANDSTONE_SLABLOOPHOLE);
		entries.add(NiceBlock.SANDSTONE_WALLPIPE);
	// Decorate blocks
    	// Oak
		entries.add(NiceBlock.OAK_DECORE1);
		entries.add(NiceBlock.OAK_SUPPORT);
		entries.add(NiceBlock.OAK_BIG_SUPPORT);
		entries.add(NiceBlock.OAK_SMALL_SUPPORT);
		entries.add(NiceBlock.OAK_WALL_SUPPORT);
		entries.add(NiceBlock.OAK_WALLLANTERN);
		entries.add(NiceBlock.OAK_WALLLANTERNA);
		entries.add(NiceBlock.OAK_CROSSBAR);
		entries.add(NiceBlock.OAK_CROSSBAR_A);
		entries.add(NiceBlock.OAK_CROSSBAR_B);
		entries.add(NiceBlock.OAK_CROSSBAR_C);
		entries.add(NiceBlock.OAK_CROSSBAR_D);
		entries.add(NiceBlock.OAK_POST);
		entries.add(NiceBlock.OAK_GATE);
		entries.add(NiceBlock.OAK_GATE_PEAKS);
		entries.add(NiceBlock.OAK_PLATFORM);
		entries.add(NiceBlock.OAK_WINDOW);
		entries.add(NiceBlock.OAK_HORIZONTAL_SUPPORT);
		// Spruce
		entries.add(NiceBlock.SPRUCE_DECORE1);
		entries.add(NiceBlock.SPRUCE_SUPPORT);
		entries.add(NiceBlock.SPRUCE_BIG_SUPPORT);
		entries.add(NiceBlock.SPRUCE_SMALL_SUPPORT);
		entries.add(NiceBlock.SPRUCE_WALL_SUPPORT);
		entries.add(NiceBlock.SPRUCE_WALLLANTERN);
		entries.add(NiceBlock.SPRUCE_WALLLANTERNA);
		entries.add(NiceBlock.SPRUCE_CROSSBAR);
		entries.add(NiceBlock.SPRUCE_CROSSBAR_A);
		entries.add(NiceBlock.SPRUCE_CROSSBAR_B);
		entries.add(NiceBlock.SPRUCE_CROSSBAR_C);
		entries.add(NiceBlock.SPRUCE_CROSSBAR_D);
		entries.add(NiceBlock.SPRUCE_POST);
		entries.add(NiceBlock.SPRUCE_GATE);
		entries.add(NiceBlock.SPRUCE_GATE_PEAKS);
		entries.add(NiceBlock.SPRUCE_PLATFORM);
		entries.add(NiceBlock.SPRUCE_WINDOW);
		entries.add(NiceBlock.SPRUCE_HORIZONTAL_SUPPORT);

		entries.add(NiceBlock.BRIDGE);
		entries.add(NiceBlock.CANNON);
		entries.add(NiceBlock.MORTIRER);
		entries.add(NiceBlock.CRATE1);
		entries.add(NiceBlock.CRATE4);
		entries.add(NiceBlock.CRATE2);
		entries.add(NiceBlock.CRATE3);
		entries.add(NiceBlock.GLOBE);
		entries.add(NiceBlock.TELESCOPE);
		entries.add(NiceBlock.FLOWERBED_ROSE_BUSH);
		entries.add(NiceBlock.FLOWERBED_PEONY);
		entries.add(NiceBlock.FLOWERBED_LILAC);
		entries.add(NiceBlock.FLOWERBED_BLUE_ORCHID);
		entries.add(NiceBlock.FLOWERBED_RED_TULIP);
		entries.add(NiceBlock.FLOWERBED_DANDELION);
		entries.add(NiceBlock.FLOWERBED_OXEYE_DAISY);
		entries.add(NiceBlock.GLASS_PANEL);
		entries.add(NiceBlock.WEATHERCOCK);
	// Worcker blocks
		entries.add(NiceBlock.BELL);
		entries.add(NiceBlock.PIPE);
		entries.add(NiceBlock.VALVE);
	// Test
		entries.add(NiceBlock.COBBLESTONE_OAK_FENCE);
		entries.add(NiceBlock.CARRIAGE_CANNON);
	})
	.build();
}
