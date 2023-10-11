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

public class Decor2 extends Horizontal{
    public Decor2(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> Block.createCuboidShape(0, 0, 0, 16, 3, 16);
			case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 3, 16);
			case EAST -> Block.createCuboidShape(0, 0, 0, 16, 3, 16);
			case WEST -> Block.createCuboidShape(0, 0, 0, 16, 3, 16);
			default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		};
	}
}
