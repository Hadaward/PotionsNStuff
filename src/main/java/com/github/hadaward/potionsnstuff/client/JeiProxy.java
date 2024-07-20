package com.github.hadaward.potionsnstuff.client;

import com.github.hadaward.potionsnstuff.PotionsNStuffMod;
import com.github.hadaward.potionsnstuff.util.BrewingRecipeData;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JeiProxy implements IModPlugin {
    private static final List<BrewingRecipeData> brewingRecipesData = new ArrayList<>();
    public static final ResourceLocation ID = new ResourceLocation(PotionsNStuffMod.MODID, PotionsNStuffMod.MODID);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();

        List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();

        for (var data : brewingRecipesData) {
            brewingRecipes.add(data.buildJeiRecipe(factory));
        }


        registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
    }

    public static void addBrewingRecipeData(BrewingRecipeData data) {
        brewingRecipesData.add(data);
    }
}
