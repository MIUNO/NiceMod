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

public class BigSupport extends Horizontal {	
    public BigSupport(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> VoxelShapes.union(Block.createCuboidShape(5, 0, 13, 11, 13, 16), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case SOUTH -> VoxelShapes.union(Block.createCuboidShape(5, 0, 0, 11, 13, 3), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case EAST -> VoxelShapes.union(Block.createCuboidShape(0, 0, 5, 3, 13, 11), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case WEST -> VoxelShapes.union(Block.createCuboidShape(13, 0, 5, 16, 13, 11), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}
