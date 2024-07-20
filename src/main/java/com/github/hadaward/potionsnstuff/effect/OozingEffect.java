package com.github.hadaward.potionsnstuff.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class OozingEffect extends MobEffect {
    private boolean slimeWasSpawned = false;
    public OozingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (!slimeWasSpawned && pLivingEntity.isDeadOrDying() && pLivingEntity.tickCount - pLivingEntity.getLastHurtByMobTimestamp() < 10) {
            spawnSlime(
                    pLivingEntity.level,
                    pLivingEntity.getX() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5),
                    pLivingEntity.getY() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5),
                    pLivingEntity.getZ() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5)
            );

            spawnSlime(
                    pLivingEntity.level,
                    pLivingEntity.getX() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5),
                    pLivingEntity.getY() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5),
                    pLivingEntity.getZ() + pLivingEntity.level.random.nextIntBetweenInclusive(-5, 5)
            );

            slimeWasSpawned = true;
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    public void spawnSlime(Level world, double x, double y, double z) {
        // Create the Slime entity
        LivingEntity slime = EntityType.SLIME.create(world);

        if (slime != null) {
            // Set the position of the Slime
            slime.setPos(x, y, z);

            // Add the Slime to the world
            world.addFreshEntity(slime);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
