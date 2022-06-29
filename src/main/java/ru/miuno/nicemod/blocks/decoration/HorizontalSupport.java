package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.HorizontalHalf;

public class HorizontalSupport extends HorizontalHalf{
    public HorizontalSupport(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            return switch(dir) {
                case NORTH -> Block.createCuboidShape(5, 0, 0, 11, 3, 16);
                case SOUTH -> Block.createCuboidShape(5, 0, 0, 11, 3, 16);
                case WEST -> Block.createCuboidShape(0, 0, 5, 16, 3, 11);
                case EAST -> Block.createCuboidShape(0, 0, 5, 16, 3, 11);
                default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
            };
        } else {
            return switch(dir) {
                case NORTH -> Block.createCuboidShape(5, 13, 0, 11, 16, 16);
                case SOUTH -> Block.createCuboidShape(5, 13, 0, 11, 16, 16);
                case WEST -> Block.createCuboidShape(0, 13, 5, 16, 16, 11);
                case EAST -> Block.createCuboidShape(0, 13, 5, 16, 16, 11);
                default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
            };
        }
    }
}
