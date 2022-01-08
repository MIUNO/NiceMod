package ru.miuno.nicemod.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Half;

public class Basis extends Half {
    public Basis(Settings settings) {
      super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        BlockHalf dir = state.get(HALF);
        switch(dir) {
            case TOP:
                return VoxelShapes.union(VoxelShapes.cuboid(0, 0.5, 0, 1, 1, 1), VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.5, 0.875));
            case BOTTOM:
                return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.5, 1), VoxelShapes.cuboid(0.125, 0.5, 0.125, 0.875, 1, 0.875));
            default:
                return VoxelShapes.fullCube();
        }
    }
}

