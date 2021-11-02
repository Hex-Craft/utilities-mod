package com.hexcraft.specshelper.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TpsBlock extends Block {
    public TpsBlock(String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
}
