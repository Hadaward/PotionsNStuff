package com.github.hadaward.potionsnstuff.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BlessedEffect extends MobEffect {
    private final Random rng = new Random();

    public BlessedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.level.random.nextIntBetweenInclusive(0, 100) < 8) {
            if (pLivingEntity.getMobType() == MobType.UNDEAD) {
                pLivingEntity.hurt(DamageSource.MAGIC, (pAmplifier + 1) * rng.nextFloat(0.2f, 2.8f));
            } else {
                pLivingEntity.heal((pAmplifier + 1) * rng.nextFloat(0.25f, 2.0f));
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }



    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
