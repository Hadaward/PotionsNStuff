package com.github.hadaward.potionsnstuff.util;

import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;

import java.util.List;

public record BrewingRecipeData(ItemStack input, ItemStack output, List<ItemStack> catalysts) {
    public static ItemStack itemStackFromPotion(Potion potion) {
        ItemStack itemStack = new ItemStack(Items.POTION.asItem());
        itemStack.setTag(new CompoundTag());
        PotionUtils.setPotion(itemStack, potion);
        return itemStack;
    }

    public IJeiBrewingRecipe buildJeiRecipe(IVanillaRecipeFactory factory) {
        return factory.createBrewingRecipe(
                this.catalysts,
                this.input,
                this.output
        );
    }
}
