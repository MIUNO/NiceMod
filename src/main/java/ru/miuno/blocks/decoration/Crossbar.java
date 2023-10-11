package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.PillarHalf;

public class Crossbar extends PillarHalf {
    public Crossbar(Settings settings) {
        super(settings);
    }

    @Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Axis dir = state.get(AXIS);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            return switch (dir) {
			    case X -> Block.createCuboidShape(0, 0, 4, 16, 8, 12);
			    case Y -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			    case Z -> Block.createCuboidShape(4, 0, 0, 12, 8, 16);
			    default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		    };
        } else {
            return switch (dir) {
			    case X -> Block.createCuboidShape(0, 8, 4, 16, 16, 12);
			    case Y -> Block.createCuboidShape(4, 0, 4, 12, 16, 12);
			    case Z -> Block.createCuboidShape(4, 8, 0, 12, 16, 16);
			    default -> Block.createCuboidShape(0, 0, 0, 12, 16, 16);
            };
        }
	}
}