package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Horizontal;

public class WallLantern extends Horizontal {
	public WallLantern(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> VoxelShapes.union(/*Block.createCuboidShape(5, 0, 0, 11, 7, 6),*/ Block.createCuboidShape(5, 0, 13, 11, 13, 16), Block.createCuboidShape(5, 13, 0, 11, 16, 16));
			case SOUTH -> VoxelShapes.union(/*Block.createCuboidShape(5, 0, 10, 11, 7, 16),*/ Block.createCuboidShape(5, 0, 0, 11, 13, 3), Block.createCuboidShape(5, 13, 0, 11, 16, 16));
			case EAST -> VoxelShapes.union(/*Block.createCuboidShape(10, 0, 5, 16, 7, 11),*/ Block.createCuboidShape(0, 0, 5, 3, 13, 11), Block.createCuboidShape(0, 13, 5, 16, 16, 11));
			case WEST -> VoxelShapes.union(/*Block.createCuboidShape(0, 0, 5, 6, 7, 11),*/ Block.createCuboidShape(13, 0, 5, 16, 13, 11), Block.createCuboidShape(0, 13, 5, 16, 16, 11));
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}
