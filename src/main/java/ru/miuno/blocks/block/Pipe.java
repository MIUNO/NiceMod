package ru.miuno.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import ru.miuno.blocks.block_types.APipe;

public class Pipe extends APipe {
    public Pipe(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canConnect(World world, BlockState state, BlockPos pos, BlockState other, Direction dir) {
        return other.getBlock() instanceof APipe pipe;
    }

    @Override
    public BlockState buildDefaultState(ItemPlacementContext ctx) {
        BlockState state = getDefaultState();
        state = state.with(FACING, ctx.getSide().getOpposite());

        for (Direction dir : Direction.values()) {
            state = state.with(CONNECTIONS.get(dir), false);
        }

        return state;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}