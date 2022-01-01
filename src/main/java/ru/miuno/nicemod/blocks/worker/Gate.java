package ru.miuno.nicemod.blocks.worker;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Gate extends HorizontalFacingBlock {

    public static final BooleanProperty OPEN = Properties.OPEN;
    public Gate(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(OPEN, false));
    }

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(Properties.HORIZONTAL_FACING).add(new Property[]{OPEN});;
	}
	@Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((Boolean)state.get(OPEN)) {
            Direction dir = state.get(FACING);
            switch(dir) {
                case NORTH:
                    return VoxelShapes.cuboid(0, 0, 0.8, 1, 1, 1);
                case SOUTH:
                    return VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.2);
                case EAST:
                    return VoxelShapes.cuboid(0, 0, 0, 0.2, 1, 1);
                case WEST:
                    return VoxelShapes.cuboid(0.8, 0, 0, 1, 1, 1);
                default:
                    return VoxelShapes.fullCube();
                }
            } else {
                Direction dir = state.get(FACING);
                switch(dir) {
                    case NORTH:
                        return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0.8, 1, 1, 1), VoxelShapes.cuboid(0.175, 0, 0, 0.825, 1, 0.8));
                    case SOUTH:
                        return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.2), VoxelShapes.cuboid(0.175, 0, 0.2, 0.825, 1, 1));
                    case EAST:
                        return VoxelShapes.union(VoxelShapes.cuboid(0, 0, 0, 0.2, 1, 1), VoxelShapes.cuboid(0.2, 0, 0.175, 1, 1, 0.825));
                    case WEST:
                        return VoxelShapes.union(VoxelShapes.cuboid(0.8, 0, 0, 1, 1, 1), VoxelShapes.cuboid(0, 0, 0.175, 0.8, 1, 0.825));
                    default:
                        return VoxelShapes.fullCube();
                    }
            }
    }
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
           boolean bl = (Boolean)state.get(OPEN);
           if (bl != world.isReceivingRedstonePower(pos)) {
              if (bl) {
                 world.createAndScheduleBlockTick(pos, this, 0);
                 world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.6F);
              } else {
                 world.setBlockState(pos, (BlockState)state.cycle(OPEN), 2);
                 world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.25F + 0.6F);
              }
           }
           
        }
     }
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if ((Boolean)state.get(OPEN) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, (BlockState)state.cycle(OPEN), 2);
        }
    }

    @Nullable
    @Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)((BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite())).with(OPEN, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
	}
}