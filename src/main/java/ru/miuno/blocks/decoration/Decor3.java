package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;

public class Decor3 extends Horizontal{
    public Decor3(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			case SOUTH -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			case EAST -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			case WEST -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}
