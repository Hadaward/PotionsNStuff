package com.github.hadaward.potionsnstuff.potion;

import com.github.hadaward.potionsnstuff.PotionsNStuffMod;
import com.github.hadaward.potionsnstuff.effect.ModEffects;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, PotionsNStuffMod.MODID);

    public static final RegistryObject<Potion> HOLY_WATER = POTIONS.register(
            "holy_water",
            () -> new Potion(
                    new MobEffectInstance(ModEffects.BLESSED.get(), 160, 0)
            )
    );

    public static final RegistryObject<Potion> INFESTED_POTION = POTIONS.register(
            "infested",
            () -> new Potion(
                    new MobEffectInstance(ModEffects.INFESTED.get(), 3600, 0)
            )
    );

    public static final RegistryObject<Potion> HASTE_POTION = POTIONS.register(
            "haste",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0)
            )
    );

    public static final RegistryObject<Potion> GLOWING_POTION = POTIONS.register(
            "glowing",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.GLOWING, 900, 0)
            )
    );

    public static final RegistryObject<Potion> NAUSEA_POTION = POTIONS.register(
            "nausea",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 0)
            )
    );

    public static final RegistryObject<Potion> MINING_FATIGUE_POTION = POTIONS.register(
            "mining_fatigue",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 0)
            )
    );

    public static final RegistryObject<Potion> DECAY_POTION = POTIONS.register(
            "wither",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.WITHER, 800, 0)
            )
    );

    public static final RegistryObject<Potion> ABSORPTION_POTION = POTIONS.register(
            "absorption",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0)
            )
    );

    public static final RegistryObject<Potion> HUNGER_POTION = POTIONS.register(
            "hunger",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.HUNGER, 600, 0)
            )
    );

    public static final RegistryObject<Potion> LEVITATION_POTION = POTIONS.register(
            "levitation",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.LEVITATION, 200, 0)
            )
    );

    public static final RegistryObject<Potion> BLINDNESS_POTION = POTIONS.register(
            "blindness",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.BLINDNESS, 400, 0)
            )
    );

    public static final RegistryObject<Potion> RESISTANCE_POTION = POTIONS.register(
            "resistance",
            () -> new Potion(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 340, 0)
            )
    );

    public static final RegistryObject<Potion> SATURATION_POTION = POTIONS.register(
            "saturation",
            () -> new Potion(
                    new MobEffectInstance(ModEffects.SATURATION.get(), 600, 0)
            )
    );

    public static final RegistryObject<Potion> OOZING_POTION = POTIONS.register(
            "oozing",
            () -> new Potion(
                    new MobEffectInstance(ModEffects.OOZING.get(), 3600, 0)
            )
    );

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
