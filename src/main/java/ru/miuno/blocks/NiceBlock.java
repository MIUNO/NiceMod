package ru.miuno.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ru.miuno.NiceMod;
import ru.miuno.blocks.block.Basis;
import ru.miuno.blocks.block.Bell;
import ru.miuno.blocks.block.Capital;
import ru.miuno.blocks.block.Column;
import ru.miuno.blocks.block.Deepening;
import ru.miuno.blocks.block.Hole;
import ru.miuno.blocks.block.Loophole;
import ru.miuno.blocks.block.Pipe;
import ru.miuno.blocks.block.Recess;
import ru.miuno.blocks.block.Recess_a;
import ru.miuno.blocks.block.SlabHole;
import ru.miuno.blocks.block.SlabLoophole;
import ru.miuno.blocks.block.SlabRecess;
import ru.miuno.blocks.block.SlabRecess_a;
import ru.miuno.blocks.block.WallPipe;
import ru.miuno.blocks.block.WoodWall;
import ru.miuno.blocks.decoration.BigSupport;
import ru.miuno.blocks.decoration.Bridge;
import ru.miuno.blocks.decoration.Cannon;
import ru.miuno.blocks.decoration.Crate;
import ru.miuno.blocks.decoration.Crossbar;
import ru.miuno.blocks.decoration.CrossbarA;
import ru.miuno.blocks.decoration.CrossbarB;
import ru.miuno.blocks.decoration.CrossbarPlatform;
import ru.miuno.blocks.decoration.CrossbarSupport;
import ru.miuno.blocks.decoration.Decor;
import ru.miuno.blocks.decoration.Decor2;
import ru.miuno.blocks.decoration.Decor3;
import ru.miuno.blocks.decoration.GateBlock;
import ru.miuno.blocks.decoration.GateBlockPeaks;
import ru.miuno.blocks.decoration.GlassPanel;
import ru.miuno.blocks.decoration.HorizontalSupport;
import ru.miuno.blocks.decoration.Platform;
import ru.miuno.blocks.decoration.Post;
import ru.miuno.blocks.decoration.SmallSupport;
import ru.miuno.blocks.decoration.Support;
import ru.miuno.blocks.decoration.Valve;
import ru.miuno.blocks.decoration.WallLantern;
import ru.miuno.blocks.decoration.WallLanternA;
import ru.miuno.blocks.decoration.WallSupport;
import ru.miuno.blocks.decoration.Weathercock;
import ru.miuno.blocks.decoration.Window;


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
    public static final Block COBBLESTONE_DEEPENING = registerBlock("cobblestone_deepening", new Deepening(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_LOOPHOLE = registerBlock("cobblestone_loophole", new Loophole(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_SLABLOOPHOLE = registerBlock("cobblestone_slabloophole", new SlabLoophole(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block COBBLESTONE_WALLPIPE = registerBlock("cobblestone_wallpipe", new WallPipe(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
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
    public static final Block COBBLED_DEEPSLATE_DEEPENING = registerBlock("cobbled_deepslate_deepening", new Deepening(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_LOOPHOLE = registerBlock("cobbled_deepslate_loophole", new Loophole(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_SLABLOOPHOLE = registerBlock("cobbled_deepslate_slabloophole", new SlabLoophole(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
    public static final Block COBBLED_DEEPSLATE_WALLPIPE = registerBlock("cobbled_deepslate_wallpipe", new WallPipe(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
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
    public static final Block STONE_DEEPENING = registerBlock("stone_deepening", new Deepening(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_LOOPHOLE = registerBlock("stone_loophole", new Loophole(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_SLABLOOPHOLE = registerBlock("stone_slabloophole", new SlabLoophole(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block STONE_WALLPIPE = registerBlock("stone_wallpipe", new WallPipe(FabricBlockSettings.copy(Blocks.STONE)));
    // Stone Bricks
    public static final Block STONE_BRICK_BASIS = registerBlock("stone_brick_basis", new Basis(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_COLUMN = registerBlock("stone_brick_column", new Column(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_CAPITAL = registerBlock("stone_brick_capital", new Capital(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_HOLE = registerBlock("stone_brick_hole", new Hole(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_RECESS = registerBlock("stone_brick_recess", new Recess(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_RECESS_A = registerBlock("stone_brick_recess_a", new Recess_a(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_SLABHOLE = registerBlock("stone_brick_slabhole", new SlabHole(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_SLABRECESS = registerBlock("stone_brick_slabrecess", new SlabRecess(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_SLABRECESS_A = registerBlock("stone_brick_slabrecess_a", new SlabRecess_a(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_DEEPENING = registerBlock("stone_brick_deepening", new Deepening(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_LOOPHOLE = registerBlock("stone_brick_loophole", new Loophole(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_SLABLOOPHOLE = registerBlock("stone_brick_slabloophole", new SlabLoophole(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_BRICK_WALLPIPE = registerBlock("stone_brick_wallpipe", new WallPipe(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
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
    public static final Block SANDSTONE_DEEPENING = registerBlock("sandstone_deepening", new Deepening(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_LOOPHOLE = registerBlock("sandstone_loophole", new Loophole(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_SLABLOOPHOLE = registerBlock("sandstone_slabloophole", new SlabLoophole(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_WALLPIPE = registerBlock("sandstone_wallpipe", new WallPipe(FabricBlockSettings.copy(Blocks.SANDSTONE)));

// Decorate blocks
    // Oak
    public static final Block OAK_DECORE1 = registerBlock("oak_iron_armor_stand", new Decor(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_SUPPORT = registerBlock("oak_support", new Support(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_BIG_SUPPORT = registerBlock("oak_big_support", new BigSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_SMALL_SUPPORT = registerBlock("oak_small_support", new SmallSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_WALL_SUPPORT = registerBlock("oak_wall_support", new WallSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_WALLLANTERN = registerBlock("oak_wall_lantern", new WallLantern(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block OAK_WALLLANTERNA = registerBlock("oak_wall_lantern_a", new WallLanternA(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block OAK_CROSSBAR = registerBlock("oak_crossbar", new Crossbar(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_CROSSBAR_A = registerBlock("oak_crossbar_a", new CrossbarA(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_CROSSBAR_B = registerBlock("oak_crossbar_b", new CrossbarB(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_CROSSBAR_C = registerBlock("oak_crossbar_support", new CrossbarSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_CROSSBAR_D = registerBlock("oak_crossbar_platform", new CrossbarPlatform(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_POST = registerBlock("oak_post", new Post(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_GATE = registerBlock("oak_gate", new GateBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_GATE_PEAKS = registerBlock("oak_gate_peaks", new GateBlockPeaks(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_PLATFORM = registerBlock("oak_platform", new Platform(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_WINDOW = registerBlock("oak_window", new Window(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_HORIZONTAL_SUPPORT = registerBlock("oak_horizontal_support", new HorizontalSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    // Spruce
    public static final Block SPRUCE_DECORE1 = registerBlock("spruce_iron_armor_stand", new Decor(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_SUPPORT = registerBlock("spruce_support", new Support(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_BIG_SUPPORT = registerBlock("spruce_big_support", new BigSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_SMALL_SUPPORT = registerBlock("spruce_small_support", new SmallSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_WALL_SUPPORT = registerBlock("spruce_wall_support", new WallSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_WALLLANTERN = registerBlock("spruce_wall_lantern", new WallLantern(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block SPRUCE_WALLLANTERNA = registerBlock("spruce_wall_lantern_a", new WallLanternA(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block SPRUCE_CROSSBAR = registerBlock("spruce_crossbar", new Crossbar(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_CROSSBAR_A = registerBlock("spruce_crossbar_a", new CrossbarA(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_CROSSBAR_B = registerBlock("spruce_crossbar_b", new CrossbarB(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_CROSSBAR_C = registerBlock("spruce_crossbar_support", new CrossbarSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_CROSSBAR_D = registerBlock("spruce_crossbar_platform", new CrossbarPlatform(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_POST = registerBlock("spruce_post", new Post(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_GATE = registerBlock("spruce_gate", new GateBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_GATE_PEAKS = registerBlock("spruce_gate_peaks", new GateBlockPeaks(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_PLATFORM = registerBlock("spruce_platform", new Platform(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_WINDOW = registerBlock("spruce_window", new Window(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_HORIZONTAL_SUPPORT = registerBlock("spruce_horizontal_support", new HorizontalSupport(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block BRIDGE = registerBlock("bridge", new Bridge(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CANNON = registerBlock("cannon", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MORTIRER = registerBlock("mortirer", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CRATE1 = registerBlock("crate1", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE4 = registerBlock("crate1_a", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE2 = registerBlock("crate2", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CRATE3 = registerBlock("crate3", new Crate(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block GLOBE = registerBlock("globe", new Decor3(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block TELESCOPE = registerBlock("telescope", new Decor3(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_ROSE_BUSH = registerBlock("flowerbed_rose_bush", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_PEONY = registerBlock("flowerbed_peony", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_LILAC = registerBlock("flowerbed_lilac", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_BLUE_ORCHID = registerBlock("flowerbed_blue_orchid", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_RED_TULIP = registerBlock("flowerbed_red_tulip", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_DANDELION = registerBlock("flowerbed_dandelion", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FLOWERBED_OXEYE_DAISY = registerBlock("flowerbed_oxeye_daisy", new Decor2(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block GLASS_PANEL = registerBlock("glass_panel", new GlassPanel(FabricBlockSettings.copy(Blocks.GLASS_PANE)));

    // Glass
    public static final Block WEATHERCOCK = registerBlock("weathercock", new Weathercock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    
// Worcker blocks
    public static final Block BELL = registerBlock("bell", new Bell(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PIPE = registerBlock("pipe", new Pipe(FabricBlockSettings.copy(Blocks.COPPER_BLOCK)));
    public static final Block VALVE = registerBlock("valve", new Valve(FabricBlockSettings.copy(Blocks.COPPER_BLOCK)));

// Test
    public static final Block COBBLESTONE_OAK_FENCE = registerBlock("cobblestone_oak_fence", new WoodWall(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
    public static final Block CARRIAGE_CANNON = registerBlock("carriage_cannon", new Cannon(FabricBlockSettings.copy(Blocks.OAK_LOG)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(NiceMod.MOD_ID, name), block);
    }
    
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(NiceMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        System.out.println("registering mod blocks for"+NiceMod.MOD_ID);
    }
}
