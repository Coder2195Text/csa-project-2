package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.NotJavascriptMod;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class UnluckyBlockOpenProcedure {
	public static void hi(LevelAccessor world, double x, double y, double z) {
		RandomSource rand = RandomSource.create();
		for (int i=0;i<300;i++) {
			NotJavascriptMod.queueServerWork(Mth.nextInt(rand, 1, 100), () -> {
				if (world instanceof ServerLevel level) {
					LightningBolt lightning = EntityType.LIGHTNING_BOLT.spawn(level, BlockPos.containing(x+Mth.nextDouble(rand, -5, 5), y+Mth.nextDouble(rand, -5, 5), z+Mth.nextDouble(rand, -5, 5)), MobSpawnType.MOB_SUMMONED);
					if (lightning != null) {
						lightning.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			});
		}
	}
	public static void execute(LevelAccessor world, double x, double y, double z) {
		hi(world,x,y,z);
	}
}
