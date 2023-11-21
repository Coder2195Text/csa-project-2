package com.coder2195.notjavascript.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.coder2195.notjavascript.init.NotJavascriptModEntities;

public class NuclearBombIgniteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isClientSide()) return;
		if (world instanceof ServerLevel level) {
			Entity entityToSpawn = NotJavascriptModEntities.NUCLEAR_BOMB_ENTITY.get().spawn(level,
					BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
