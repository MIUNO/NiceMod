// based on the code by octalide https://github.com/octalide/pipette
package ru.miuno.blocks.block_types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public abstract class APipe extends Block implements Waterloggable {
    public static final VoxelShape CORE_SHAPE = Block.createCuboidShape(5, 5, 5, 11, 11, 11);
    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(5, 5, 0, 11, 11, 5);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(5, 5, 11, 11, 11, 16);
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(11, 5, 5, 16, 11, 11);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0, 5, 5, 5, 11, 11);
    public static final VoxelShape UP_SHAPE = Block.createCuboidShape(5, 11, 5, 11, 16, 11);
    public static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(5, 0, 5, 11, 5, 11);
    public static final DirectionProperty FACING = DirectionProperty.of("facing");
    public static final Map<Direction, BooleanProperty> CONNECTIONS = new HashMap<>();
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public APipe(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(WATERLOGGED, false));
    }
    
    public Direction facing(BlockState state) {
        return state.get(FACING);
    }

    public abstract boolean canConnect(World world, BlockState state, BlockPos pos, BlockState other, Direction dir);
    public abstract BlockState buildDefaultState(ItemPlacementContext ctx);
    public abstract BlockEntity createBlockEntity(BlockPos pos, BlockState state);

    public ArrayList<Direction> connections(BlockState state) {
        ArrayList<Direction> connections = new ArrayList<>();

        for (Direction dir : Direction.values()) {
            if (hasConnection(state, dir)) {
                connections.add(dir);
            }
        }

        return connections;
    }

    public boolean hasConnection(BlockState state, Direction dir) {
        return state.get(CONNECTIONS.get(dir));
    }

    public BlockState setConnection(BlockState state, Direction dir, boolean value) {
        return state.with(CONNECTIONS.get(dir), value);
    }

    public void updateConnections(World world, BlockState state, BlockPos pos) {
        if (world.isClient()) {
            return;
        }

        for (Direction dir : Direction.values()) {
            BlockPos offset = pos.offset(dir);
            BlockState other = world.getBlockState(offset);

            state = setConnection(state, dir, canConnect(world, state, pos, other, dir));

            world.setBlockState(pos, state);
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        updateConnections(world, state, pos);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        updateConnections(world, state, pos);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(WATERLOGGED);
        for (Direction dir : Direction.values()) {
            CONNECTIONS.put(dir, BooleanProperty.of(dir.getName()));
            builder.add(CONNECTIONS.get(dir));
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        VoxelShape shape = CORE_SHAPE;
        VoxelShape shape2 = CORE_SHAPE;
        for (Direction dir : Direction.values()) {
            if (hasConnection(state, dir)) {
                shape2 = switch (dir) {
                    case NORTH -> VoxelShapes.union(shape, NORTH_SHAPE);
                    case SOUTH -> VoxelShapes.union(shape, SOUTH_SHAPE);
                    case EAST -> VoxelShapes.union(shape, EAST_SHAPE);
                    case WEST -> VoxelShapes.union(shape, WEST_SHAPE);
                    case UP -> VoxelShapes.union(shape, UP_SHAPE);
                    case DOWN -> VoxelShapes.union(shape, DOWN_SHAPE);
                };
            }
            Direction dir2 = state.get(FACING);
            shape = switch (dir2) {
                case NORTH -> VoxelShapes.union(shape2, NORTH_SHAPE);
                case SOUTH -> VoxelShapes.union(shape2, SOUTH_SHAPE);
                case EAST -> VoxelShapes.union(shape2, EAST_SHAPE);
                case WEST -> VoxelShapes.union(shape2, WEST_SHAPE);
                case UP -> VoxelShapes.union(shape2, UP_SHAPE);
                case DOWN -> VoxelShapes.union(shape2, DOWN_SHAPE);
            };  
        }       
        return shape;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return this.buildDefaultState(ctx).with(WATERLOGGED, bl);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}