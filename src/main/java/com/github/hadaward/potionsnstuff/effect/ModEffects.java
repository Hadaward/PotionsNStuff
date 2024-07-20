package com.github.hadaward.potionsnstuff.effect;

import com.github.hadaward.potionsnstuff.PotionsNStuffMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotionsNStuffMod.MODID);

    public static final RegistryObject<MobEffect> INFESTED = MOB_EFFECTS.register(
            "infested",
            () -> new InfestedEffect(MobEffectCategory.HARMFUL, 9214860)
    );

    public static final RegistryObject<MobEffect> OOZING = MOB_EFFECTS.register(
            "oozing",
            () -> new OozingEffect(MobEffectCategory.HARMFUL, 10092451)
    );

    public static final RegistryObject<MobEffect> SATURATION = MOB_EFFECTS.register(
            "saturation",
            () -> new SaturationEffect(MobEffectCategory.BENEFICIAL, 16262179)
    );

    public static final RegistryObject<MobEffect> BLESSED = MOB_EFFECTS.register(
            "blessed",
            () -> new BlessedEffect(MobEffectCategory.NEUTRAL, 14276820)
    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
