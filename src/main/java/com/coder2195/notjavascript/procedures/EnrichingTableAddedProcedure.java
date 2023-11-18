package com.coder2195.notjavascript.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class EnrichingTableAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isClientSide())
			return;
		BlockPos blockPos = BlockPos.containing(x, y, z);
		BlockEntity blockEntity = world.getBlockEntity(blockPos);
		BlockState blockState = world.getBlockState(blockPos);
		if (blockEntity != null)
			blockEntity.getPersistentData().putDouble("enrich_time", 1);
		if (world instanceof Level level)
			level.sendBlockUpdated(blockPos, blockState, blockState, 3);
	}
}
