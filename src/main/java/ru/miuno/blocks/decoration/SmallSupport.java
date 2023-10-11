package ru.miuno.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;

public class SmallSupport extends Horizontal {
    public SmallSupport(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0.15, 0.25, 0.875, 0.85, 0.875, 1), VoxelShapes.cuboid(0.15, 0.875, 0.25, 0.85, 1, 1));
			case SOUTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0.15, 0.25, 0, 0.85, 0.875, 0.125), VoxelShapes.cuboid(0.15, 0.875, 0, 0.85, 1, 0.75));
			case EAST:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0.25, 0.15, 0.125, 0.875, 0.85), VoxelShapes.cuboid(0, 0.875, 0.15, 0.75, 1, 0.85));
			case WEST:
				return VoxelShapes.union(VoxelShapes.cuboid(0.875, 0.25, 0.15, 1, 0.875, 0.85), VoxelShapes.cuboid(0.25, 0.875, 0.15, 1, 1, 0.85));
			default:
				return VoxelShapes.fullCube();
		}
	}
}
