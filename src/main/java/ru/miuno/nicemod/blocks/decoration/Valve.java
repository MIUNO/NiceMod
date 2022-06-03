package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.WaterloggableRodBlock;

public class Valve extends WaterloggableRodBlock {
	public Valve(Settings settings) {
		super(settings);
	}

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.35, 0.6875);
            case DOWN -> VoxelShapes.cuboid(0.3125, 0.65, 0.3125, 0.6875, 1, 0.6875);
            case NORTH -> VoxelShapes.cuboid(0.3125, 0.3125, 0.65, 0.6875, 0.6875, 1);
            case SOUTH -> VoxelShapes.cuboid(0.3125, 0.3125, 0, 0.6875, 0.6875, 0.35);
            case EAST -> VoxelShapes.cuboid(0, 0.3125, 0.3125, 0.35, 0.6875, 0.6875);
            case WEST -> VoxelShapes.cuboid(0.65, 0.3125, 0.3125, 1, 0.6875, 0.6875);
        };
    }
}