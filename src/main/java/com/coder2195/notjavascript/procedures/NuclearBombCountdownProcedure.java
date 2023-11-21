package com.coder2195.notjavascript.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class NuclearBombCountdownProcedure {
	public static void execute(Entity e) {
		if (e == null)
			return;
		if (e instanceof LivingEntity entity) { 
			double health = entity.getHealth();
			if (health < .1) return;
			entity.setHealth((float) (health - 0.05));
		}
	}
}
