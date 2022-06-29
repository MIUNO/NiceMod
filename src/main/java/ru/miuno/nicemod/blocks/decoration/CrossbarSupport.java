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

public class CrossbarSupport extends Horizontal {
    public CrossbarSupport(Settings settings) {
        super(settings);
    }
    
    @Override  
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> VoxelShapes.union(Block.createCuboidShape(4, 0, 8, 12, 13, 16), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case SOUTH -> VoxelShapes.union(Block.createCuboidShape(4, 0, 0, 12, 13, 8), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case EAST -> VoxelShapes.union(Block.createCuboidShape(0, 0, 4, 8, 13, 12), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			case WEST -> VoxelShapes.union(Block.createCuboidShape(8, 0, 4, 16, 13, 12), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}
