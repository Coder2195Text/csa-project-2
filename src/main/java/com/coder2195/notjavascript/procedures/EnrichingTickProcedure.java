package com.coder2195.notjavascript.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

import com.coder2195.notjavascript.init.NotJavascriptModItems;

public class EnrichingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double enrichTime = 0;
		ItemStack output = ItemStack.EMPTY;
		boolean outputValid = false;
		BlockEntity blockEntity = world.getBlockEntity(BlockPos.containing(x, y, z));
		if (BlockEntityMethods.getItemStack(world, blockEntity, 0).getItem() == Items.BLAZE_ROD && BlockEntityMethods.getItemStack(world, blockEntity, 1).getItem() == NotJavascriptModItems.RAW_URANIUM.get()) {
			enrichTime = BlockEntityMethods.getDoubleTag(world, blockEntity, "enrich_time") + 1;
			output = BlockEntityMethods.getItemStack(world, blockEntity, 2);
			outputValid = output.getItem() == ItemStack.EMPTY.getItem() || output.getItem() == NotJavascriptModItems.RAW_URANIUM.get();
			if (!outputValid) {
				return;
			}
			if (enrichTime % 60 == 0) {
				{
					
					if (blockEntity != null) {
						final int _slotid = 0;
						final int _amount = 1;
						blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
			}
			if (enrichTime % 1200 == 0) {
				if (outputValid) {
					{
						if (blockEntity != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(NotJavascriptModItems.RAW_URANIUM.get());
							_setstack.setCount((int) (output.getItem() == ItemStack.EMPTY.getItem() ? 1 : output.getCount() + 1));
							blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					{
						if (blockEntity != null) {
							final int _slotid = 1;
							final int _amount = 1;
							blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_slotid).copy();
									_stk.shrink(_amount);
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
								}
							});
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("enrich_time", 1);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("enrich_time", enrichTime);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("enrich_time", 1);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
