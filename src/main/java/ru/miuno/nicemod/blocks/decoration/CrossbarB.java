package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Horizontal;

public class CrossbarB extends Horizontal {
    public CrossbarB(Settings settings) {
        super(settings);
    }
	
    @Override  
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0.25, 0, 0.5, 0.75, 1, 1);
			case SOUTH:
				return VoxelShapes.cuboid(0.25, 0, 0, 0.75, 1, 0.5);
			case EAST:
				return VoxelShapes.cuboid(0, 0, 0.25, 0.5, 1, 0.75);
			case WEST:
				return VoxelShapes.cuboid(0.5, 0, 0.25, 1, 1, 0.75);
			default:
				return VoxelShapes.fullCube();
		}
	}
}
