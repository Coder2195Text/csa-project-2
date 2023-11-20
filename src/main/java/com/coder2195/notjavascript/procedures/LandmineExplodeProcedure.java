package com.coder2195.notjavascript.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

public class LandmineExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world.isClientSide())
			return;
		if (world instanceof Level level) {
			level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
		}
	}
}
