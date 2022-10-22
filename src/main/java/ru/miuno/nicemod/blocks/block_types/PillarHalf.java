package ru.miuno.nicemod.blocks.block_types;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class PillarHalf extends PillarBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;

    public PillarHalf(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(((BlockState)(BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(WATERLOGGED, false)).with(AXIS, Direction.Axis.Y)).with(HALF, BlockHalf.BOTTOM));
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction.Axis dir = state.get(AXIS);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            switch(dir) {
                case X:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                case Y:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                case Z:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                default:
                    return VoxelShapes.fullCube();
            }
        } else {
            switch(dir) {
                case X:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                case Y:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                case Z:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);
                default:
                    return VoxelShapes.fullCube();
            }
        }
    }
    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        Direction direction = ctx.getSide();
        blockState = ctx.canReplaceExisting() || !direction.getAxis().isHorizontal() ? (BlockState)((BlockState)blockState.with(AXIS, ctx.getSide().getAxis())).with(HALF, direction == Direction.UP ? BlockHalf.BOTTOM : BlockHalf.TOP) : (BlockState)((BlockState)blockState.with(AXIS, ctx.getSide().getAxis())).with(HALF, ctx.getHitPos().y - (double)ctx.getBlockPos().getY() > 0.5 ? BlockHalf.TOP : BlockHalf.BOTTOM);
        return (BlockState)blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return state;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}