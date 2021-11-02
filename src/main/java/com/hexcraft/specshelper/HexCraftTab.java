package com.hexcraft.specshelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HexCraftTab extends CreativeTabs {

    public HexCraftTab(String name) {
        super("specshelper." + name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BlocksRegister.TPS_BLOCK);
    }

}
