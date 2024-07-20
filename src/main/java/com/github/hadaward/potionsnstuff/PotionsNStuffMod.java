package com.github.hadaward.potionsnstuff;

import com.github.hadaward.potionsnstuff.effect.ModEffects;
import com.github.hadaward.potionsnstuff.potion.ModPotions;
import com.github.hadaward.potionsnstuff.util.PotionBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PotionsNStuffMod.MODID)
public class PotionsNStuffMod
{
    public static final String MODID = "potionsnstuff";

    public PotionsNStuffMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Blocks.STONE.asItem(),
                            ModPotions.INFESTED_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.SWIFTNESS,
                            Items.GOLDEN_APPLE,
                            ModPotions.HASTE_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Blocks.GLOWSTONE.asItem(),
                            ModPotions.GLOWING_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.PUFFERFISH,
                            ModPotions.NAUSEA_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.PRISMARINE_SHARD,
                            ModPotions.MINING_FATIGUE_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.WITHER_ROSE,
                            ModPotions.DECAY_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.REGENERATION,
                            Items.GOLD_NUGGET,
                            ModPotions.ABSORPTION_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.ROTTEN_FLESH,
                            ModPotions.HUNGER_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.SHULKER_SHELL,
                            ModPotions.LEVITATION_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.FERMENTED_SPIDER_EYE,
                            ModPotions.BLINDNESS_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.SLIME_BALL,
                            ModPotions.RESISTANCE_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.DANDELION,
                            ModPotions.SATURATION_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Blocks.SLIME_BLOCK.asItem(),
                            ModPotions.OOZING_POTION.get()
                    )
            );

            BrewingRecipeRegistry.addRecipe(
                    new PotionBrewingRecipe(
                            Potions.AWKWARD,
                            Items.NETHER_STAR,
                            ModPotions.HOLY_WATER.get()
                    )
            );

            /*
            @TODO: Criar poção sagrada
            @TODO: Criar bracelete e pedras
            BrewingRecipeRegistry.addRecipe(
                new TestBrewingRecipe(
                        Items.POTION,
                        Items.APPLE,
                        Items.ENCHANTED_GOLDEN_APPLE
                )
            );*/
        });
    }
}
