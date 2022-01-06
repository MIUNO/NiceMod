package ru.miuno.nicemod.blocks.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
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
import org.jetbrains.annotations.Nullable;

public class Loophole extends HorizontalFacingBlock implements Waterloggable {
    public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public Loophole(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(((BlockState)(BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(WATERLOGGED, false)).with(FACING, Direction.NORTH)).with(HALF, BlockHalf.BOTTOM));
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
    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        Direction direction = ctx.getSide();
        blockState = ctx.canReplaceExisting() || !direction.getAxis().isHorizontal() ? (BlockState)((BlockState)blockState.with(FACING, ctx.getPlayerFacing().getOpposite())).with(HALF, direction == Direction.UP ? BlockHalf.BOTTOM : BlockHalf.TOP) : (BlockState)((BlockState)blockState.with(FACING, direction)).with(HALF, ctx.getHitPos().y - (double)ctx.getBlockPos().getY() > 0.5 ? BlockHalf.TOP : BlockHalf.BOTTOM);
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
        builder.add(FACING, HALF, WATERLOGGED);
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
        return true;
    }
}