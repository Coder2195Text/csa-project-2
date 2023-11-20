
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import com.coder2195.notjavascript.NotJavascriptMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NotJavascriptModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NotJavascriptMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(NotJavascriptModBlocks.ENRICHING_TABLE.get().asItem());
			tabData.accept(NotJavascriptModBlocks.NUCLEAR_BOMB.get().asItem());
			tabData.accept(NotJavascriptModItems.ROLLWAVE_DISC.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(NotJavascriptModBlocks.LANDMINE.get().asItem());
			tabData.accept(NotJavascriptModItems.DEPLETED_URANIUM_ARMOR_HELMET.get());
			tabData.accept(NotJavascriptModItems.DEPLETED_URANIUM_ARMOR_CHESTPLATE.get());
			tabData.accept(NotJavascriptModItems.DEPLETED_URANIUM_ARMOR_LEGGINGS.get());
			tabData.accept(NotJavascriptModItems.DEPLETED_URANIUM_ARMOR_BOOTS.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(NotJavascriptModItems.RAW_URANIUM.get());
			tabData.accept(NotJavascriptModItems.ENRICHED_URANIUM.get());
			tabData.accept(NotJavascriptModItems.NUCLEAR_BOMB_CORE.get());
			tabData.accept(NotJavascriptModItems.DEPLETED_URANIUM.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(NotJavascriptModBlocks.URANIUM_ORE.get().asItem());
		}
	}
}
