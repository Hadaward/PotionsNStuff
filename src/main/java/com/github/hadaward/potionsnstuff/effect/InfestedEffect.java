package com.github.hadaward.potionsnstuff.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class InfestedEffect extends MobEffect {
    public InfestedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.getLastHurtByMob() != null && pLivingEntity.tickCount - pLivingEntity.getLastHurtByMobTimestamp() < 2) {
            if (pLivingEntity.level.random.nextInt(0,100) <= 10) {
                for (int i=0; i<pLivingEntity.level.random.nextIntBetweenInclusive(1, 2); i++) {
                    spawnSilverfish(pLivingEntity.level, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ());
                }
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    public void spawnSilverfish(Level world, double x, double y, double z) {
        // Create the Silverfish entity
        LivingEntity silverfish = EntityType.SILVERFISH.create(world);

        if (silverfish != null) {
            // Set the position of the Silverfish
            silverfish.setPos(x, y, z);

            // Add the Silverfish to the world
            world.addFreshEntity(silverfish);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
