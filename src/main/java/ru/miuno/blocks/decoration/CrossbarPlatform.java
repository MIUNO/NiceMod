package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.WaterloggableBlock;

public class CrossbarPlatform extends WaterloggableBlock {
    public CrossbarPlatform(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(Block.createCuboidShape(4, 0, 4, 12, 16, 12), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
    }
}
