package ru.miuno.nicemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class Capital extends Block {

    protected Capital(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());
    }
    
}
