package com.github.hadaward.potionsnstuff.util;

import com.github.hadaward.potionsnstuff.client.JeiProxy;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBrewingRecipe implements IBrewingRecipe {
    private final Item input;
    private final Item ingredient;
    private final Item output;

    public ItemBrewingRecipe(Item input, Item ingredient, Item output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;

        JeiProxy.addBrewingRecipeData(
            new BrewingRecipeData(
                    this.input.getDefaultInstance(),
                    this.output.getDefaultInstance(),
                    List.of(this.ingredient.getDefaultInstance())
            )
        );
    }

    @Override
    public boolean isInput(@NotNull ItemStack input) {
        return input.getItem() == this.input;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }

    @Override
    public @NotNull ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
        if(!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(this.output);
    }
}