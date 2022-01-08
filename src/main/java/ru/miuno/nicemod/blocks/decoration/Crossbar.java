package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.PillarHalf;

public class Crossbar extends PillarHalf {
    public Crossbar(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction.Axis dir = state.get(AXIS);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            switch(dir) {
                case X:
                    return VoxelShapes.cuboid(0, 0, 0.25, 1, 0.5, 0.75);
                case Y:
                    return VoxelShapes.cuboid(0.25, 0.0, 0.25,  0.75,  1.0, 0.75);
                case Z:
                    return VoxelShapes.cuboid(0.25, 0, 0,  0.75, 0.5, 1);
                default:
                    return VoxelShapes.fullCube();
            }
        } else {
            switch(dir) {
                case X:
                    return VoxelShapes.cuboid(0, 0.5, 0.25, 1, 1, 0.75);
                case Y:
                    return VoxelShapes.cuboid(0.25, 0.0, 0.25,  0.75,  1.0, 0.75);
                case Z:
                    return VoxelShapes.cuboid(0.25, 0.5, 0,  0.75, 1, 1);
                default:
                    return VoxelShapes.fullCube();
            }
        }
    }
}