package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;

public class WallLanternA extends Horizontal {
    public WallLanternA(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> VoxelShapes.union(Block.createCuboidShape(5, 0, 5, 11, 13, 11), Block.createCuboidShape(-8, 13, 5, 24, 16, 11));
			case SOUTH -> VoxelShapes.union(Block.createCuboidShape(5, 0, 5, 11, 13, 11), Block.createCuboidShape(-8, 13, 5, 24, 16, 11));
			case EAST -> VoxelShapes.union(Block.createCuboidShape(5, 0, 5, 11, 13, 11), Block.createCuboidShape(5, 13, -8, 11, 16, 24));
			case WEST -> VoxelShapes.union(Block.createCuboidShape(5, 0, 5, 11, 13, 11), Block.createCuboidShape(5, 13, -8, 11, 16, 24));
			default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		};
	}
}
