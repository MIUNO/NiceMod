package ru.miuno.blocks.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WoodWall extends WallBlock {
   public static EnumProperty<WallShape> NORTH_WALL = NORTH_SHAPE;
    public static EnumProperty<WallShape> EAST_WALL = EAST_SHAPE;
    public static EnumProperty<WallShape> SOUTH_WALL = SOUTH_SHAPE;
    public static EnumProperty<WallShape> WEST_WALL = WEST_SHAPE;
    public final Map<BlockState, VoxelShape> blockShape;
    public final Map<BlockState, VoxelShape> blockShapeCollision;
    public static final VoxelShape POST_SHAPE = Block.createCuboidShape(5, 0, 5, 11, 16, 11);
    public static final VoxelShape NORTH_SHAPE_LOW = Block.createCuboidShape(7, 0, 0, 9, 14, 9);
    public static final VoxelShape SOUTH_SHAPE_LOW = Block.createCuboidShape(7, 0, 7, 9, 14, 16);
    public static final VoxelShape WEST_SHAPE_LOW = Block.createCuboidShape(0, 0, 7, 9.0, 14, 9);
    public static final VoxelShape EAST_SHAPE_LOW = Block.createCuboidShape(7, 0, 7, 16, 14, 9);
    public static final VoxelShape NORTH_SHAPE_TALL = Block.createCuboidShape(7, 0, 0, 9, 16, 9);
    public static final VoxelShape SOUTH_SHAPE_TALL = Block.createCuboidShape(7, 0, 7, 9, 16, 16);
    public static final VoxelShape WEST_SHAPE_TALL = Block.createCuboidShape(0, 0, 7, 9, 16, 9);
    public static final VoxelShape EAST_SHAPE_TALL = Block.createCuboidShape(7, 0, 7, 16, 16, 9);

    public WoodWall(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
        this.blockShape = this.makeShapes(POST_SHAPE, NORTH_SHAPE_LOW, EAST_SHAPE_LOW, SOUTH_SHAPE_LOW, WEST_SHAPE_LOW, NORTH_SHAPE_TALL, EAST_SHAPE_TALL, SOUTH_SHAPE_TALL, WEST_SHAPE_TALL);
        this.blockShapeCollision = this.makeShapes(POST_SHAPE, NORTH_SHAPE_LOW, EAST_SHAPE_LOW, SOUTH_SHAPE_LOW, WEST_SHAPE_LOW, NORTH_SHAPE_TALL, EAST_SHAPE_TALL, SOUTH_SHAPE_TALL, WEST_SHAPE_TALL);
    }

    public Map<BlockState, VoxelShape> makeShapes(VoxelShape post, VoxelShape north_low, VoxelShape east_low, VoxelShape south_low, VoxelShape west_low, VoxelShape north_tall, VoxelShape east_tall, VoxelShape south_tall, VoxelShape west_tall) {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        for(Boolean is_up : UP.getValues()) {
            for (WallShape wall_north : NORTH_WALL.getValues()) {
                for (WallShape wall_east : EAST_WALL.getValues()) {
                    for (WallShape wall_south : SOUTH_WALL.getValues()) {
                        for (WallShape wall_west : WEST_WALL.getValues()) {
                            VoxelShape shape = VoxelShapes.empty();
                            if (is_up == true){ shape = post; }
                            if (wall_north == WallShape.TALL) { shape = VoxelShapes.union(shape, north_tall); }
                            if (wall_north == WallShape.LOW) { shape = VoxelShapes.union(shape, north_low); }
                            if (wall_east == WallShape.TALL) { shape = VoxelShapes.union(shape, east_tall); }
                            if (wall_east == WallShape.LOW) { shape = VoxelShapes.union(shape, east_low); }
                            if (wall_south == WallShape.TALL) { shape = VoxelShapes.union(shape, south_tall); }
                            if (wall_south == WallShape.LOW) { shape = VoxelShapes.union(shape, south_low); }
                            if (wall_west == WallShape.TALL) { shape = VoxelShapes.union(shape, west_tall); }
                            if (wall_west == WallShape.LOW) { shape = VoxelShapes.union(shape, west_low); }
                            BlockState state = this.getDefaultState().with(UP, is_up).with(NORTH_WALL, wall_north).with(EAST_WALL, wall_east).with(SOUTH_WALL, wall_south).with(WEST_WALL, wall_west);
                            builder.put(state.with(WATERLOGGED, Boolean.valueOf(false)), shape);
                            builder.put(state.with(WATERLOGGED, Boolean.valueOf(true)), shape);
                        }
                    }
                }
            }
        } return builder.build();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return this.blockShape.get(state);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.blockShapeCollision.get(state);
    }
}
