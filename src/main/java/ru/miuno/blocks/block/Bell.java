package ru.miuno.blocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import ru.miuno.NiceMod;

public class Bell extends Block {
    public Bell(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return this.ring(world, blockPos) ? ActionResult.success(world.isClient) : ActionResult.PASS;
     }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(6, 0, 6, 10, 3, 10);
    }
    
    public boolean ring(World world, BlockPos blockPos) {
        if (!world.isClient) {
           world.playSound(null, blockPos, NiceMod.BELL_EVENT, SoundCategory.BLOCKS, 0.5f, 1f);
           return true;
        } else {
           return false;
        }
    }
}
