package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.WaterloggableRodBlock;

public class Valve extends WaterloggableRodBlock {
	public Valve(Settings settings) {
		super(settings);
	}

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> Block.createCuboidShape(5, 0, 5, 11, 5, 11);
            case DOWN -> Block.createCuboidShape(5, 11, 5, 11, 16, 11);
            case NORTH -> Block.createCuboidShape(5, 5, 11, 11, 11, 16);
            case SOUTH -> Block.createCuboidShape(5, 5, 0, 11, 11, 5);
            case EAST -> Block.createCuboidShape(0, 5, 5, 5, 11, 11);
            case WEST -> Block.createCuboidShape(11, 5, 5, 16, 11, 11);
        };
    }
}