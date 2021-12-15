package ru.miuno.nicemod.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.miuno.nicemod.NiceMod;
import ru.miuno.nicemod.itemgroup.NiceItemGroup;

public class NiceBlock {
    //  Blocks
    public static final Block COCOA_BEANS_BLOCK = registerBlock("cobblestone_basis", new Basis(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLED_DEEPSLATE_BASIS = registerBlock("cobbled_deepslate_basis", new Basis(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLESTONE_COLUMN = registerBlock("cobblestone_column", new Column(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLED_DEEPSLATE_COLUMN = registerBlock("cobbled_deepslate_column", new Column(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLESTONE_CAPITAL = registerBlock("cobblestone_capital", new Capital(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLED_DEEPSLATE_CAPITAL = registerBlock("cobbled_deepslate_capital", new Capital(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLESTONE_HOLE = registerBlock("cobblestone_hole", new Hole(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLED_DEEPSLATE_HOLE = registerBlock("cobbled_deepslate_hole", new Hole(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLESTONE_RECESS = registerBlock("cobblestone_recess", new Recess(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block COBBLED_DEEPSLATE_RECESS = registerBlock("cobbled_deepslate_recess", new Recess(FabricBlockSettings.of(Material.STONE).strength(3.5f, 6.0f)));
    public static final Block BRIDGE = registerBlock("bridge", new Bridge(FabricBlockSettings.of(Material.WOOD).strength(3.5f, 6.0f)));

    //  Register
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(NiceMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(NiceMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(NiceItemGroup.ITEM_GROUP)));
    }
    public static void registerModBlocks(){
        System.out.println("registering mod blocks for"+NiceMod.MOD_ID);
    }
}