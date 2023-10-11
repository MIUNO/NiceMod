package ru.miuno.blocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Pillar;

public class Column extends Pillar {
    public Column(Settings settings) {
        super(settings);
    }

   /* @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction.Axis)state.get(AXIS)) {
            default: {
                return VoxelShapes.cuboid(0, 0.125, 0.125,  1,  0.875, 0.875);
            }
            case Z: {
                return VoxelShapes.cuboid(0.125, 0.125, 0.0,  0.875,  0.875, 1.0);
            }
            case Y: 
        }
        return VoxelShapes.cuboid(0.125, 0.0, 0.125,  0.875,  1.0, 0.875);
    }*/
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Axis dir = state.get(AXIS);
		return switch (dir) {
			case X -> Block.createCuboidShape(0, 2, 2, 16, 14, 14);
			case Y -> Block.createCuboidShape(2, 0, 2, 14, 16, 14);
			case Z -> Block.createCuboidShape(2, 2, 0, 14, 14, 16);
			default -> Block.createCuboidShape(16, 16, 16, 16, 16, 16);
		};
	}
}
