package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class WallLanternA extends WallLantern {
    public WallLanternA(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.union(VoxelShapes.cuboid(-0.5, 0, 0.3, 1.5, 1, 0.7));
			case SOUTH:
				return VoxelShapes.union(VoxelShapes.cuboid(-0.5, 0, 0.3, 1.5, 1, 0.7));
			case EAST:
				return VoxelShapes.union(VoxelShapes.cuboid(0.3, 0, -0.5, 0.7, 1, 1.5));
			case WEST:
				return VoxelShapes.union(VoxelShapes.cuboid(0.3, 0, -0.5, 0.7, 1, 1.5));
			default:
				return VoxelShapes.fullCube();
		}
	}
}
