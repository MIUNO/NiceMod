package ru.miuno.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.WaterloggableBlock;

public class Capital extends WaterloggableBlock {

    public Capital(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.125, 1), VoxelShapes.cuboid(0.125, 0.125, 0.125, 0.875, 1, 0.875), VoxelShapes.cuboid(0, 0.875, 0, 1, 1, 1));
    }
}
