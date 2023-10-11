package ru.miuno.blocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.HorizontalHalf;

public class SlabLoophole extends HorizontalHalf {
    public SlabLoophole(Settings settings) {
        super(settings);
    }
    
    @Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            return switch (dir) {
			    case NORTH -> VoxelShapes.union(Block.createCuboidShape(0, 0, 8, 16, 4, 16), Block.createCuboidShape(0, 0, 8, 4, 16, 16), Block.createCuboidShape(12, 0, 8, 16, 16, 16));
			    case SOUTH -> VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 16, 4, 8), Block.createCuboidShape(0, 0, 0, 4, 16, 8), Block.createCuboidShape(12, 0, 0, 16, 16, 8));
			    case WEST -> VoxelShapes.union(Block.createCuboidShape(8, 0, 0, 16, 4, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 4), Block.createCuboidShape(8, 0, 12, 16, 16, 16));
			    case EAST -> VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 8, 4, 16), Block.createCuboidShape(0, 0, 0, 8, 16, 4), Block.createCuboidShape(0, 0, 12, 8, 16, 16));
			    default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		    };
        } else {
            return switch (dir) {
			    case NORTH -> VoxelShapes.union(Block.createCuboidShape(0, 12, 8, 16, 16, 16), Block.createCuboidShape(0, 0, 8, 4, 16, 16), Block.createCuboidShape(12, 0, 8, 16, 16, 16));
			    case SOUTH -> VoxelShapes.union(Block.createCuboidShape(0, 12, 0, 16, 16, 8), Block.createCuboidShape(0, 0, 0, 4, 16, 8), Block.createCuboidShape(12, 0, 0, 16, 16, 8));
			    case WEST -> VoxelShapes.union(Block.createCuboidShape(8, 12, 0, 16, 16, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 4), Block.createCuboidShape(8, 0, 12, 16, 16, 16));
			    case EAST -> VoxelShapes.union(Block.createCuboidShape(0, 12, 0, 8, 16, 16), Block.createCuboidShape(0, 0, 0, 8, 16, 4), Block.createCuboidShape(0, 0, 12, 8, 16, 16));
			    default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16); 
            };
        }
	}
}
