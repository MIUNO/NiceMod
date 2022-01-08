package ru.miuno.nicemod.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Pillar;

public class Column extends Pillar {
    public Column(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction.Axis)state.get(AXIS)) {
            default: {
                return VoxelShapes.cuboid(0, 0.125, 0.125,  1,  0.875, 0.875);
            }
            case Z: {
                return VoxelShapes.cuboid(0.125, 0.125, 0.0,  0.875,  0.875, 1.0);
            }
            case Y: 
        }
        return VoxelShapes.cuboid(0.125, 0.0, 0.125,  0.875,  1.0, 0.875);
    }
}
