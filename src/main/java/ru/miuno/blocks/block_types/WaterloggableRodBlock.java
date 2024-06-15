package ru.miuno.blocks.block_types;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RodBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class WaterloggableRodBlock extends RodBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	public WaterloggableRodBlock(Settings settings) {
		super(settings);
        setDefaultState(getDefaultState()
		.with(Properties.FACING, Direction.UP)
		.with(WATERLOGGED, false));
	}

    @Override
    protected MapCodec<? extends RodBlock> getCodec() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState()
            .with(Properties.FACING, ctx.getSide())
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
		return switch (dir) {
            case UP -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
            case DOWN -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			case NORTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			case EAST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			case WEST -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		};
	}

	/*public WaterloggableRodBlock(Settings settings) {
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
        return false;
    }*/
}