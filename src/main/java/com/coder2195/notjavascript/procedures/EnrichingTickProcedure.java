package com.coder2195.notjavascript.procedures;

import com.coder2195.notjavascript.init.NotJavascriptModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class EnrichingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double enrichTime = 0;
		ItemStack output = ItemStack.EMPTY;
		ItemStack output2 = ItemStack.EMPTY;
		boolean outputValid = false;
		BlockPos blockPos = BlockPos.containing(x, y, z);
		BlockEntity blockEntity = world.getBlockEntity(blockPos);

		if (blockEntity == null)
			return;

		if (BlockEntityMethods.getItemStack(world, blockEntity, 0).getItem() == Items.BLAZE_ROD && BlockEntityMethods
				.getItemStack(world, blockEntity, 1).getItem() == NotJavascriptModItems.RAW_URANIUM.get()) {
			enrichTime = BlockEntityMethods.getDoubleTag(world, blockEntity, "enrich_time") + 1;
			output = BlockEntityMethods.getItemStack(world, blockEntity, 2);
			output2 = BlockEntityMethods.getItemStack(world, blockEntity, 3);
			outputValid = (output.getItem() == ItemStack.EMPTY.getItem()
					|| output.getItem() == NotJavascriptModItems.ENRICHED_URANIUM.get())
					&& (output2.getItem() == ItemStack.EMPTY.getItem()
							|| output2.getItem() == NotJavascriptModItems.DEPLETED_URANIUM.get());
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
			if (enrichTime % 6 == 0 && outputValid) {
				boolean enriched = world.getRandom().nextDouble() < 0.2;
				ItemStack oldOut = enriched ? output : output2;
				final ItemStack outputStack = new ItemStack(
						(enriched ? NotJavascriptModItems.ENRICHED_URANIUM : NotJavascriptModItems.DEPLETED_URANIUM).get());
				outputStack.setCount(oldOut.getItem() == ItemStack.EMPTY.getItem() ? 1 : oldOut.getCount() + 1);
				blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(cap -> {

					if (cap instanceof IItemHandlerModifiable capability) {
						capability.setStackInSlot(enriched ? 2 : 3, outputStack);

						ItemStack stack = cap.getStackInSlot(1).copy();
						stack.shrink(1);
						capability.setStackInSlot(1, stack);
					}
				});

				if (!world.isClientSide()) {
					BlockEntityMethods.setDoubleTag(world, blockEntity, "enrich_time", 1);
				}

				return;
			}
			if (!world.isClientSide()) {
				BlockEntityMethods.setDoubleTag(world, blockEntity, "enrich_time", enrichTime);
			}
		} else {
			if (!world.isClientSide()) {
				BlockEntityMethods.setDoubleTag(world, blockEntity, "enrich_time", 1);
			}
		}
	}
}
