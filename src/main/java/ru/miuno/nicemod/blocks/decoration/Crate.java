package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Horizontal;

public class Crate extends Horizontal {
    public Crate(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.6, 1));
			case SOUTH:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.6, 1));
			case EAST:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.6, 1));
			case WEST:
				return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.6, 1));
			default:
				return VoxelShapes.fullCube();
		}
	}
}