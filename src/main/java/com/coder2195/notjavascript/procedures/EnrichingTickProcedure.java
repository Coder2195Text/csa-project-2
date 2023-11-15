package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.init.NotJavascriptModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class EnrichingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double enrichTime = 0;
		ItemStack output = ItemStack.EMPTY;
		boolean outputValid = false;
		BlockPos blockPos = BlockPos.containing(x, y, z);
		BlockEntity blockEntity = world.getBlockEntity(blockPos);
		BlockState blockState = world.getBlockState(blockPos);

		if (blockEntity == null)
			return;

		if (BlockEntityMethods.getItemStack(world, blockEntity, 0).getItem() == Items.BLAZE_ROD && BlockEntityMethods
				.getItemStack(world, blockEntity, 1).getItem() == NotJavascriptModItems.RAW_URANIUM.get()) {
			enrichTime = BlockEntityMethods.getDoubleTag(world, blockEntity, "enrich_time") + 1;
			output = BlockEntityMethods.getItemStack(world, blockEntity, 2);
			outputValid = output.getItem() == ItemStack.EMPTY.getItem()
					|| output.getItem() == NotJavascriptModItems.ENRICHED_URANIUM.get();
			if (!outputValid)
				return;

			if (enrichTime % 3 == 0) {
				blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						ItemStack stack = capability.getStackInSlot(0).copy();
						stack.shrink(1);
						((IItemHandlerModifiable) capability).setStackInSlot(0, stack);
					}
				});
			}
			if (enrichTime % 5 == 0 && outputValid) {

				final ItemStack outputStack = new ItemStack(NotJavascriptModItems.ENRICHED_URANIUM.get());
				outputStack.setCount(output.getItem() == ItemStack.EMPTY.getItem() ? 1 : output.getCount() + 1);
				blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(cap -> {
					if (cap instanceof IItemHandlerModifiable capability) {
						capability.setStackInSlot(2, outputStack);

						ItemStack stack = cap.getStackInSlot(1).copy();
						stack.shrink(1);
						capability.setStackInSlot(1, stack);
					}
				});

				if (!world.isClientSide()) {
					blockEntity.getPersistentData().putDouble("enrich_time", 1);
					if (world instanceof Level level)
						level.sendBlockUpdated(blockPos, blockState, blockState, 3);
				}

				return;
			}
			if (!world.isClientSide()) {
				blockEntity.getPersistentData().putDouble("enrich_time", enrichTime);
				if (world instanceof Level level)
					level.sendBlockUpdated(blockPos, blockState, blockState, 3);
			}
		} else {
			if (!world.isClientSide()) {
				blockEntity.getPersistentData().putDouble("enrich_time", 1);
				if (world instanceof Level level)
					level.sendBlockUpdated(blockPos, blockState, blockState, 3);
			}
		}
	}
}
