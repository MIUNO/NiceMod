package ru.miuno.nicemod.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.miuno.nicemod.NiceMod;
import ru.miuno.nicemod.itemgroup.NiceItemGroup;

public class NiceBlock {
    //  Blocks
    public static final Block COBBLESTONE_BASIS = registerBlock("cobblestone_basis", new Basis(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_COLUMN = registerBlock("cobblestone_column", new Column(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_CAPITAL = registerBlock("cobblestone_capital", new Capital(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_HOLE = registerBlock("cobblestone_hole", new Hole(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_RECESS = registerBlock("cobblestone_recess", new Recess(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_SLABRECESS = registerBlock("cobblestone_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.COBBLESTONE)));

    public static final Block COBBLED_DEEPSLATE_BASIS = registerBlock("cobbled_deepslate_basis", new Basis(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_COLUMN = registerBlock("cobbled_deepslate_column", new Column(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_CAPITAL = registerBlock("cobbled_deepslate_capital", new Capital(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_HOLE = registerBlock("cobbled_deepslate_hole", new Hole(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_RECESS = registerBlock("cobbled_deepslate_recess", new Recess(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_SLABRECESS = registerBlock("cobbled_deepslate_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.DEEPSLATE)));

    public static final Block SANDSTONE_BASIS = registerBlock("sandstone_basis", new Basis(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_COLUMN = registerBlock("sandstone_column", new Column(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_CAPITAL = registerBlock("sandstone_capital", new Capital(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_HOLE = registerBlock("sandstone_hole", new Hole(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_RECESS = registerBlock("sandstone_recess", new Recess(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_SLABRECESS = registerBlock("sandstone_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.SANDSTONE)));

    /// Decorate blocks
    public static final Block BRIDGE = registerBlock("bridge", new Bridge(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CANNON = registerBlock("cannon", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MORTIRER = registerBlock("mortirer", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CRATE1 = registerBlock("crate1", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE2 = registerBlock("crate2", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE3 = registerBlock("crate3", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

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