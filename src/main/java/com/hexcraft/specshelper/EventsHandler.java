package com.hexcraft.specshelper;

import akka.event.BusLogging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class EventsHandler {

    @SubscribeEvent
    public static void onJoin(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            player.sendMessage(new TextComponentString("Привет, %p!".replace("%p", player.getName())));
        }
    }

    @SubscribeEvent
    public static void ItemCraftedEvent(PlayerEvent.ItemCraftedEvent event) {
        ItemStack stack = event.crafting;
        if (stack.getUnlocalizedName().equals("tps_block")) {
            System.out.println("Tps block crafted.");
        }
        System.out.println("Item crafted.");
    }
}