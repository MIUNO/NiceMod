package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;

public class WallSupport extends Horizontal {
    public WallSupport(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> Block.createCuboidShape(5, 0, 13, 11, 16, 16);
			case SOUTH -> Block.createCuboidShape(5, 0, 0, 11, 16, 3);
			case EAST -> Block.createCuboidShape(0, 0, 5, 3, 16, 11);
			case WEST -> Block.createCuboidShape(13, 0, 5, 16, 16, 11);
			default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		};
	}
}
