
package com.coder2195.notjavascript.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.coder2195.notjavascript.entity.NuclearBombEntityEntity;
import com.coder2195.notjavascript.client.model.ModelBlock;

public class NuclearBombEntityRenderer extends MobRenderer<NuclearBombEntityEntity, ModelBlock<NuclearBombEntityEntity>> {
	public NuclearBombEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBlock(context.bakeLayer(ModelBlock.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(NuclearBombEntityEntity entity) {
		return new ResourceLocation("not_javascript:textures/entities/nuclear_bomb_entity.png");
	}

	@Override
	protected boolean isShaking(NuclearBombEntityEntity entity) {
		return true;
	}
}
