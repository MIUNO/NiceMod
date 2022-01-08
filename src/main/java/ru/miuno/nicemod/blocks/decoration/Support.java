package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Horizontal;

public class Support extends Horizontal {
    public Support(Settings settings) {
        super(settings);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0.3, 0, 0.875, 0.7, 0.875, 1), VoxelShapes.cuboid(0.3, 0.875, 0, 0.7, 1, 1));
			case SOUTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0.3, 0, 0, 0.7, 0.875, 0.125), VoxelShapes.cuboid(0.3, 0.875, 0, 0.7, 1, 1));
			case EAST:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0.3, 0.125, 0.875, 0.7), VoxelShapes.cuboid(0, 0.875, 0.3, 1, 1, 0.7));
			case WEST:
				return VoxelShapes.union(VoxelShapes.cuboid(0.875, 0, 0.3, 1, 0.875, 0.7), VoxelShapes.cuboid(0, 0.875, 0.3, 1, 1, 0.7));
			default:
				return VoxelShapes.fullCube();
		}
	}
}
