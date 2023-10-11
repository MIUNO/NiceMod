package ru.miuno.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.HorizontalHalf;

public class Loophole extends HorizontalHalf{
    public Loophole(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            switch(dir) {
                case NORTH:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1));
                case SOUTH:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1));
                case WEST:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
                case EAST:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
                default:
                    return VoxelShapes.fullCube();
            }
        } else {
            switch(dir) {
                case NORTH:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1));
                case SOUTH:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1));
                case WEST:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
                case EAST:
                    return VoxelShapes.union(VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
                default:
                    return VoxelShapes.fullCube();
            }
        }
    }
}