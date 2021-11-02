package com.hexcraft.specshelper;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {
    public static void register() {
        registerRecipes("tps_block");
    }

    private static void registerRecipes(String name) {
        CraftingHelper.register(new ResourceLocation("specshelper", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
    }
}