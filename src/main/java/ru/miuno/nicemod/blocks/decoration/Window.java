package ru.miuno.nicemod.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Window extends HorizontalFacingBlock{

    public Window(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(Properties.HORIZONTAL_FACING);
	}
 
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0, 0, 0.65, 1, 1, 0.85);
			case SOUTH:
				return VoxelShapes.cuboid(0, 0, 0.15, 1, 1, 0.35);
			case EAST:
				return VoxelShapes.cuboid(0.15, 0, 0, 0.35, 1, 1);
			case WEST:
				return VoxelShapes.cuboid(0.65, 0, 0, 0.85, 1, 1);
			default:
				return VoxelShapes.fullCube();
		}
	}
 
    @Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
	}
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return true;
    }
}
