package com.coder2195.notjavascript.procedures;

import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class BlockEntityMethods {
	public static ItemStack getItemStack(LevelAccessor world, BlockEntity blockEntity, int slotid) {
		AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
		if (blockEntity != null)
			blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
					.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
		return _retval.get();
	}

	public static double getDoubleTag(LevelAccessor world, BlockEntity blockEntity, String tag) {
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}
