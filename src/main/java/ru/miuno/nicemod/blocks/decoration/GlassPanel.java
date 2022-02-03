package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.Half;

public class GlassPanel extends Half{
    public GlassPanel(Settings settings) {
        super(settings);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        BlockHalf dir = state.get(HALF);
        switch(dir) {
            case TOP:
                return VoxelShapes.cuboid(0, 0.875, 0, 1, 1, 1);
            case BOTTOM:
                return VoxelShapes.cuboid(0, 0, 0, 1, 0.125, 1);
            default:
                return VoxelShapes.fullCube();
        }
    }
}
