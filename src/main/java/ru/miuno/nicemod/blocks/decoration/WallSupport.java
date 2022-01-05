package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class WallSupport extends Cannon {
    public WallSupport(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0.3, 0, 0.875, 0.7, 1, 1);
			case SOUTH:
				return VoxelShapes.cuboid(0.3, 0, 0, 0.7, 1, 0.125);
			case EAST:
				return VoxelShapes.cuboid(0, 0, 0.3, 0.125, 1, 0.7);
			case WEST:
				return VoxelShapes.cuboid(0.875, 0, 0.3, 1, 1, 0.7);
			default:
				return VoxelShapes.fullCube();
		}
	}
}
