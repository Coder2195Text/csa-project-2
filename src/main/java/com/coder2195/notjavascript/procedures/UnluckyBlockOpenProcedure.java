package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.NotJavascriptMod;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

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

		for (int bx = 0; bx < 21; bx++) {
			final double bxx = x + bx - 9.5;
			NotJavascriptMod.queueServerWork(bx * 5, () -> {
				if (world instanceof ServerLevel level) {
					for (double bz = z - 9.5; bz < z + 10.5; bz++) {

						level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(bxx, y + 20, bz), Vec2.ZERO, level,
										4, "",
										Component.literal(""), level.getServer(), null).withSuppressedOutput(),
								"summon tnt ~ ~ ~ {Fuse:40}");
					}
				}
			});
		}
	}

	public static void fleshy(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (world instanceof ServerLevel level) {
			ItemEntity e = new ItemEntity(level, x, y, z, new ItemStack(Items.ROTTEN_FLESH, 69420));
			e.setPickUpDelay(10);
			level.addFreshEntity(e);
		}
	}

	public static void avocados(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (world instanceof ServerLevel level) {
			for (int bx = 0; bx < 21; bx++) {
				double bxx = x + bx - 9.5;

				for (double bz = z - 9.5; bz < z + 10.5; bz++) {

					level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(bxx, y + 20, bz), Vec2.ZERO, level, 4,
									"",
									Component.literal(""), level.getServer(), null).withSuppressedOutput(),
							"summon creeper");
				}
			}
		}
	}

	public static void naughtyList(LevelAccessor world, double x, double y, double z, Entity entity) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.COAL_ORE.defaultBlockState(), 0);
	}

	public static Disaster[] disasters = {
			UnluckyBlockOpenProcedure::hi,
			UnluckyBlockOpenProcedure::famine,
			UnluckyBlockOpenProcedure::carpetBombing,
			UnluckyBlockOpenProcedure::fleshy,
			UnluckyBlockOpenProcedure::avocados,
			UnluckyBlockOpenProcedure::naughtyList,
	};

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		naughtyList(world, x, y, z, entity);

		// RandomSource rand = world.getRandom();
		// int i = Math.abs(rand.nextInt() % disasters.length);
		// disasters[i].execute(world, x, y, z, entity);
	}

}
