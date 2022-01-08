package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Horizontal;

public class Window extends Horizontal{
    public Window(Settings settings) {
        super(settings);
    }
    
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0, 0, 0.65, 1, 1, 0.85);
			case SOUTH:
				return VoxelShapes.cuboid(0, 0, 0.15, 1, 1, 0.35);
			case EAST:
				return VoxelShapes.cuboid(0.15, 0, 0, 0.35, 1, 1);
			case WEST:
				return VoxelShapes.cuboid(0.65, 0, 0, 0.85, 1, 1);
			default:
				return VoxelShapes.fullCube();
		}
	}
}
