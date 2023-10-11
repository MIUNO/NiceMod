package ru.miuno.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.WaterloggableRodBlock;

public class SlabHole extends WaterloggableRodBlock {
	public SlabHole(Settings settings) {
		super(settings);
	}

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.25, 0.5, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 0.5, 1), VoxelShapes.cuboid(0, 0, 0, 1, 0.5, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 0.5, 1));
            case DOWN -> VoxelShapes.union(VoxelShapes.cuboid(0, 0.5, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0.5, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0.5, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0.5, 0.75, 1, 1, 1));
            case NORTH -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0.5, 1, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0.5, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0.5, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0.5, 1, 1, 1));
            case SOUTH -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 0.5), VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 0.5), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 0.5), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 0.5));
            case EAST -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.5, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0, 0.5, 1, 1), VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 0.5, 1, 1));
            case WEST -> VoxelShapes.union(VoxelShapes.cuboid(0.5, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0.5, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0.5, 0, 0.75, 1, 1, 1));
        };
    }
}