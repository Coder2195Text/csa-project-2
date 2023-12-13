package com.coder2195.notjavascript.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.coder2195.notjavascript.NotJavascriptMod;

public class PlaygroundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		NotJavascriptMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 10), () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.LIGHTNING_BOLT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
	}
}
