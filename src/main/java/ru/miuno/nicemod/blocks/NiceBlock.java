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
import ru.miuno.nicemod.blocks.block.*;
import ru.miuno.nicemod.blocks.decoration.*;
import ru.miuno.nicemod.blocks.worker.Gate;
import ru.miuno.nicemod.itemgroup.NiceItemGroup;

public class NiceBlock {
//  Blocks
    // Cobblestone
    public static final Block COBBLESTONE_BASIS = registerBlock("cobblestone_basis", new Basis(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_COLUMN = registerBlock("cobblestone_column", new Column(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_CAPITAL = registerBlock("cobblestone_capital", new Capital(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_HOLE = registerBlock("cobblestone_hole", new Hole(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_RECESS = registerBlock("cobblestone_recess", new Recess(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_RECESS_A = registerBlock("cobblestone_recess_a", new Recess_a(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_SLABHOLE = registerBlock("cobblestone_slabhole", new SlabHole(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_SLABRECESS = registerBlock("cobblestone_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_SLABRECESS_A = registerBlock("cobblestone_slabrecess_a", new SlabRecess_a(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    // Cobbled deepslate
    public static final Block COBBLED_DEEPSLATE_BASIS = registerBlock("cobbled_deepslate_basis", new Basis(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_COLUMN = registerBlock("cobbled_deepslate_column", new Column(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_CAPITAL = registerBlock("cobbled_deepslate_capital", new Capital(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_HOLE = registerBlock("cobbled_deepslate_hole", new Hole(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_RECESS = registerBlock("cobbled_deepslate_recess", new Recess(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_RECESS_A = registerBlock("cobbled_deepslate_recess_a", new Recess_a(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_SLABHOLE = registerBlock("cobbled_deepslate_slabhole", new SlabHole(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_SLABRECESS = registerBlock("cobbled_deepslate_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_SLABRECESS_A = registerBlock("cobbled_deepslate_slabrecess_a", new SlabRecess_a(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    // Stone
    public static final Block STONE_BASIS = registerBlock("stone_basis", new Basis(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_COLUMN = registerBlock("stone_column", new Column(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_CAPITAL = registerBlock("stone_capital", new Capital(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_HOLE = registerBlock("stone_hole", new Hole(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_RECESS = registerBlock("stone_recess", new Recess(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_RECESS_A = registerBlock("stone_recess_a", new Recess_a(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_SLABHOLE = registerBlock("stone_slabhole", new SlabHole(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_SLABRECESS = registerBlock("stone_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_SLABRECESS_A = registerBlock("stone_slabrecess_a", new SlabRecess_a(FabricBlockSettings.copy(Blocks.STONE)));
    // Sandstone
    public static final Block SANDSTONE_BASIS = registerBlock("sandstone_basis", new Basis(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_COLUMN = registerBlock("sandstone_column", new Column(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_CAPITAL = registerBlock("sandstone_capital", new Capital(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_HOLE = registerBlock("sandstone_hole", new Hole(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_RECESS = registerBlock("sandstone_recess", new Recess(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_RECESS_A = registerBlock("sandstone_recess_a", new Recess_a(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_SLABHOLE = registerBlock("sandstone_slabhole", new SlabHole(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_SLABRECESS = registerBlock("sandstone_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_SLABRECESS_A = registerBlock("sandstone_slabrecess_a", new SlabRecess_a(FabricBlockSettings.copy(Blocks.SANDSTONE)));

// Decorate blocks
    public static final Block BRIDGE = registerBlock("bridge", new Bridge(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CANNON = registerBlock("cannon", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MORTIRER = registerBlock("mortirer", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CRATE1 = registerBlock("crate1", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE4 = registerBlock("crate1_a", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE2 = registerBlock("crate2", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE3 = registerBlock("crate3", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_SUPPORT = registerBlock("oak_support", new Support(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SMALL_OAK_SUPPORT = registerBlock("small_oak_support", new SmallSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block WALLLANTERN = registerBlock2("wall_lantern", new WallLantern(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block WALLLANTERNA = registerBlock("wall_lantern_a", new WallLanternA(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block POST = registerBlock2("post", new Post(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block WEATHERCOCK = registerBlock2("weathercock", new Weathercock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    
// Worcker blocks
    public static final Block COBBLESTONE_GATE = registerBlock("cobblestone_gate", new Gate(FabricBlockSettings.copy(Blocks.COBBLESTONE)));

    //  Register
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(NiceMod.MOD_ID, name), block);
    }
    private static Block registerBlock2(String name, Block block){
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