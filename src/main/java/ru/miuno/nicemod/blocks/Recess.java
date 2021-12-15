package ru.miuno.nicemod.blocks;

import net.minecraft.block.Material;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;


public class Recess extends Column {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public Recess(AbstractBlock.Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction.Axis)state.get(AXIS)) {
            default: {
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f,  1.0f,  1.0f, 1.0f);
            }
            case Z: {
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f,  1.0f,  1.0f, 1.0f);
            }
            case Y: 
        }
        return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f,  1.0f,  1.0f, 1.0f);
    }

}
