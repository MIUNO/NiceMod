package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Half;

public class Platform extends Half {
    public Platform(Settings settings) {
        super(settings);
    }
    
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		BlockHalf dir = state.get(HALF);
		return switch (dir) {
			case TOP -> Block.createCuboidShape(0, 13, 0, 16, 16, 16);
			case BOTTOM ->  Block.createCuboidShape(0, 0, 0, 16, 3, 16);
		};
	}
}
