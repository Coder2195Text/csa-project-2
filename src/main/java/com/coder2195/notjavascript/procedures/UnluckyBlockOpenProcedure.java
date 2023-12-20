package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.NotJavascriptMod;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class UnluckyBlockOpenProcedure {
	@FunctionalInterface
	public static interface Disaster {
		void execute(LevelAccessor world, double x, double y, double z, Entity entity);
	}

	public static void hi(LevelAccessor world, double x, double y, double z, Entity entity) {
		RandomSource rand = world.getRandom();

		for (int i = 0; i < 300; i++) {
			NotJavascriptMod.queueServerWork(Mth.nextInt(rand, 1, 100), () -> {
				if (world instanceof ServerLevel level) {
					LightningBolt lightning = EntityType.LIGHTNING_BOLT
							.spawn(level,
									BlockPos.containing(x + Mth.nextDouble(rand, -5, 5),
											y + Mth.nextDouble(rand, -5, 5), z + Mth.nextDouble(rand, -5, 5)),
									MobSpawnType.MOB_SUMMONED);
					if (lightning != null) {
						lightning.setYRot(rand.nextFloat() * 360F);
					}
				}

			});

		}
	}

	public static void famine(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity instanceof Player player) {
			player.setHealth(1);
			player.getFoodData().setFoodLevel(0);
		}
	}

	public static void carpetBombing(LevelAccessor world, double x, double y, double z, Entity entity) {
		MinecraftServer server = world.getServer();

		if (server != null)
			server.getPlayerList()
					.broadcastSystemMessage(
							Component.literal("SLEEPY JOE HAS AUTHORIZED A CARPET BOMBING OF THIS AREA!!!"), false);

		for (int bx = 0; bx < x + 11; bx++) {
			final int bxx = bx;
			NotJavascriptMod.queueServerWork(bx * 5, () -> {
				if (world instanceof ServerLevel level) {
					for (double bz = z - 5; bz < z + 5; bz++) {
						EntityType.TNT.spawn(level, BlockPos.containing(bxx - 5.0, y + 10, bz),
								MobSpawnType.MOB_SUMMONED);

					}
				}
			});

		}
	}

	public static Disaster[] disasters = {
			UnluckyBlockOpenProcedure::hi,
			UnluckyBlockOpenProcedure::famine,
			UnluckyBlockOpenProcedure::carpetBombing
	};

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		hi(world, x, y, z, entity);
		// RandomSource rand = world.getRandom();
		// int i = Math.abs(rand.nextInt() % disasters.length);
		// disasters[i].execute(world, x, y, z, entity);
	}

}
