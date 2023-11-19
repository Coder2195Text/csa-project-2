
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.coder2195.notjavascript.client.renderer.NuclearBombEntityRenderer;
import com.coder2195.notjavascript.client.renderer.NautiqueenRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NotJavascriptModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(NotJavascriptModEntities.NUCLEAR_BOMB_ENTITY.get(), NuclearBombEntityRenderer::new);
		event.registerEntityRenderer(NotJavascriptModEntities.NAUTIQUEEN.get(), NautiqueenRenderer::new);
	}
}
