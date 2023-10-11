package ru.miuno.blocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Half;

public class Basis extends Half {
    public Basis(Settings settings) {
      super(settings);
    }

    @Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		BlockHalf dir = state.get(HALF);
		return switch (dir) {
			case TOP -> VoxelShapes.union(Block.createCuboidShape(2, 0, 2, 14, 8, 14), Block.createCuboidShape(0, 8, 0, 16, 16, 16));
			case BOTTOM -> VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 16, 8, 16), Block.createCuboidShape(2, 8, 2, 14, 16, 14));
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}

