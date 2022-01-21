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

public class Decor3 extends Horizontal{
    public Decor3(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
			case SOUTH:
				return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
			case EAST:
				return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
			case WEST:
				return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
			default:
				return VoxelShapes.fullCube();
		}
	}
}
