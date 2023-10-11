package ru.miuno.blocks.block_types;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class HorizontalHalf extends HorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;

    public HorizontalHalf(Settings settings) {
		super(settings);
        setDefaultState(getDefaultState()
        .with(FACING, Direction.NORTH)
		.with(HALF, BlockHalf.BOTTOM)
		.with(WATERLOGGED, false));
	}

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState()
            .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
            .with(Properties.BLOCK_HALF, ctx.getHitPos().y - (double)ctx.getBlockPos().getY() > 0.5D ? BlockHalf.TOP : BlockHalf.BOTTOM)
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).isOf(Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            return switch (dir) {
			    case NORTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case WEST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case EAST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		    };
        } else {
            return switch (dir) {
			    case NORTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case WEST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    case EAST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			    default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
            };
        }
	}
}