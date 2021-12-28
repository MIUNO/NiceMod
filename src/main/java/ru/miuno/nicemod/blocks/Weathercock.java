package ru.miuno.nicemod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Weathercock extends LightningRodBlock {

	public Weathercock(Settings settings) {
		super(settings);
	}

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
            case DOWN -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
            case NORTH -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 1);
            case SOUTH -> VoxelShapes.cuboid(0.25, 0, 0, 0.75, 1, 0.75);
            case EAST -> VoxelShapes.cuboid(0, 0, 0.25, 0.75, 1, 0.75);
            case WEST -> VoxelShapes.cuboid(0.25, 0, 0.25, 1, 1, 0.75);
        };
    }

}
