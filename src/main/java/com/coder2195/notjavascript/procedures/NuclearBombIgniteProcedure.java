package com.coder2195.notjavascript.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class NuclearBombIgniteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockPos blockPos = BlockPos.containing(x, y, z);
		BlockEntity blockEntity = world.getBlockEntity(blockPos);
		if (!world.isClientSide()) {
			double ignitionTime = BlockEntityMethods.getDoubleTag(world, blockEntity, "ignited");
			if (ignitionTime > 0)
				return;
			BlockEntityMethods.setDoubleTag(world, blockEntity, "ignited", 60);

			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(Component.literal("NUCLEAR BOMB WILL EXPLODE IN 60 SECONDS!!!"), false);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("not_javascript:nuclear_siren")),
						SoundSource.WEATHER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z,
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("not_javascript:nuclear_siren")),
						SoundSource.WEATHER, 100, 1, false);
			}
		}
	}
}
