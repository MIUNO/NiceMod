package ru.miuno.blocks.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Pillar;

public class Hole extends Pillar {
    public Hole(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction.Axis)state.get(AXIS)) {
            default: {
                return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
            }
            case Z: {
                return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1));
            }
            case Y: 
        }
        return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 1, 1));
    }
}
