package ru.miuno.nicemod.blocks.block;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SlabHole extends RodBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	public SlabHole(Settings settings) {
		super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.UP)).with(WATERLOGGED, false));
	}

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return (BlockState)((BlockState)this.getDefaultState().with(FACING, ctx.getSide())).with(WATERLOGGED, bl);
     }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }


    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.25, 0.5, 1), VoxelShapes.cuboid(0.75, 0, 0, 1, 0.5, 1), VoxelShapes.cuboid(0, 0, 0, 1, 0.5, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 1, 0.5, 1));
            case DOWN -> VoxelShapes.union(VoxelShapes.cuboid(0, 0.5, 0, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0.5, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0.5, 0, 1, 1, 0.25), VoxelShapes.cuboid(0, 0.5, 0.75, 1, 1, 1));
            case NORTH -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0.5, 1, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0.5, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0.5, 0.25, 1, 1), VoxelShapes.cuboid(0.75, 0, 0.5, 1, 1, 1));
            case SOUTH -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 0.5), VoxelShapes.cuboid(0, 0.75, 0, 1, 1, 0.5), VoxelShapes.cuboid(0, 0, 0, 0.25, 1, 0.5), VoxelShapes.cuboid(0.75, 0, 0, 1, 1, 0.5));
            case EAST -> VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.5, 0.25, 1), VoxelShapes.cuboid(0, 0.75, 0, 0.5, 1, 1), VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 0.25), VoxelShapes.cuboid(0, 0, 0.75, 0.5, 1, 1));
            case WEST -> VoxelShapes.union(VoxelShapes.cuboid(0.5, 0, 0, 1, 0.25, 1), VoxelShapes.cuboid(0.5, 0.75, 0, 1, 1, 1), VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 0.25), VoxelShapes.cuboid(0.5, 0, 0.75, 1, 1, 1));
        };
    }
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return true;
    }
}