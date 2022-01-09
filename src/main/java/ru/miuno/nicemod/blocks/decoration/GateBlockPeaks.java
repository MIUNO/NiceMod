package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.nicemod.blocks.block_types.HorizontalHalf;

public class GateBlockPeaks extends HorizontalHalf {
    public GateBlockPeaks(AbstractBlock.Settings settings) {
        super(settings);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            switch(dir) {
                case NORTH:
				    return VoxelShapes.cuboid(0, 0, 0.4, 1, 0.8, 0.6);
			    case SOUTH:
				    return VoxelShapes.cuboid(0, 0, 0.4, 1, 0.8, 0.6);
			    case EAST:
				    return VoxelShapes.cuboid(0.4, 0, 0, 0.6, 0.8, 1);
			    case WEST:
				    return VoxelShapes.cuboid(0.4, 0, 0, 0.6, 0.8, 1);
			    default:
				    return VoxelShapes.fullCube();
            }
        } else {
            switch(dir) {
                case NORTH:
				    return VoxelShapes.cuboid(0, 0.2, 0.4, 1, 1, 0.6);
			    case SOUTH:
				    return VoxelShapes.cuboid(0, 0.2, 0.4, 1, 1, 0.6);
			    case EAST:
				    return VoxelShapes.cuboid(0.4, 0.2, 0, 0.6, 1, 1);
			    case WEST:
				    return VoxelShapes.cuboid(0.4, 0.2, 0, 0.6, 1, 1);
			    default:
				    return VoxelShapes.fullCube();
            }
        }
    }
}