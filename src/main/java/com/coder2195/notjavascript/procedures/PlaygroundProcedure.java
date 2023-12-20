package com.coder2195.notjavascript.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PlaygroundProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(1);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(0);
	}
}
