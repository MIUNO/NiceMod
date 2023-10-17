package ru.miuno.blocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WoodWall extends FenceBlock {
    VoxelShape POST_SHAPE = Block.createCuboidShape(4.0F, 0.0F, 4.0F, 12.0F, 16.0F, 12.0F);
    VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0F, 0.0F, 0.0F, 12.0F, 16.0F, 12.0F);
    VoxelShape EAST_SHAPE = Block.createCuboidShape(4.0F, 0.0F, 4.0F, 16.0F, 16.0F, 12.0F);
    VoxelShape SOUTH_SHAPE = Block.createCuboidShape(4.0F, 0.0F, 4.0F, 12.0F, 16.0F, 16.0F);
    VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0F, 0.0F, 4.0F, 12.0F, 16.0F, 12.0F);

    public WoodWall(Settings settings) {
        super(settings);
    }

    public VoxelShape makebuildShapes (BlockState state, VoxelShape post, VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
        VoxelShape shape = post;
        if (state.toString().contains("north=true")) {
            shape = VoxelShapes.union(shape, north);
        }
        if (state.toString().contains("east=true")) {
            shape = VoxelShapes.union(shape, east);
        }
        if (state.toString().contains("south=true")) {
            shape = VoxelShapes.union(shape, south);
        }
        if (state.toString().contains("west=true")) {
            shape = VoxelShapes.union(shape, west);
        }
        return shape;
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape;
        shape = makebuildShapes(state, POST_SHAPE, NORTH_SHAPE, EAST_SHAPE, SOUTH_SHAPE, WEST_SHAPE);
        return shape;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape;
        shape = makebuildShapes(state, POST_SHAPE, NORTH_SHAPE, EAST_SHAPE, SOUTH_SHAPE, WEST_SHAPE);
        return shape;
    }
}
