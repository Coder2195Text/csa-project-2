package com.coder2195.notjavascript.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class PephearConsumeProcedure {
	public static void execute(Entity e) {
		if (e == null)
			return;
		if (e instanceof LivingEntity entity && !entity.level().isClientSide())
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, false));
	}
}
