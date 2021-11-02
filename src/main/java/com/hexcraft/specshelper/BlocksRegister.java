package com.hexcraft.specshelper;

import com.hexcraft.specshelper.blocks.TpsBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegister
{
    public static final CreativeTabs TUTORIAL_TAB = new HexCraftTab("tabHexCraft");
    public static Block TPS_BLOCK = new TpsBlock("tps_block").setCreativeTab(TUTORIAL_TAB).setLightLevel(1.0f);

    public static void register()
    {
        setRegister(TPS_BLOCK);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(Item.getItemFromBlock(TPS_BLOCK));
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
