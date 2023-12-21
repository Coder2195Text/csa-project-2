package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.NotJavascriptMod;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class NuclearBombIgnitedProcedure {
	public static int chunkRadius = 8;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity e) {
		Requirements req = new Requirements();
		// hate mr holmer for giving us these requirements
		req.fulfill();

		if (world instanceof Level level) {

			if (level.isClientSide()) {
				level.playLocalSound(x, y, z,
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("not_javascript:nuclear_siren")),
						SoundSource.WEATHER, 100, 1, false);
				return;
			}

			level.playSound(null, BlockPos.containing(x, y, z),
					ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("not_javascript:nuclear_siren")),
					SoundSource.WEATHER, 100, 1);

			MinecraftServer server = world.getServer();

			if (server != null)
				server.getPlayerList()
						.broadcastSystemMessage(Component.literal("NUCLEAR BOMB WILL EXPLODE IN 60 SECONDS!!!"), false);
		}

		NotJavascriptMod.queueServerWork(1200, () -> {
			if (world instanceof ServerLevel level) {
				for (double ex = x - chunkRadius * 16; ex <= x + chunkRadius * 16; ex += 16) {
					for (double ez = z - chunkRadius * 16; ez <= z + chunkRadius * 16; ez += 16) {
						// summon fireballs from y=32 to y=256
						for (double ey = Math.max(y - Math.min(chunkRadius * 8, 100), -50); ey <= Math.min(y
								+ Math.min(chunkRadius * 8, 100), 150); ey += 16) {
							level.explode(e, ex, ey, ez, 50.0F, true, Level.ExplosionInteraction.TNT);
						}
					}
				}
				e.discard();
			}
		});
	}
}
