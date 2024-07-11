package com.kittehmod.vct.client;

import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;

public class ClientRenderers
{
	public static void initialize() {		
		EntityRenderers.register(VCTRegistry.CRAFTING_TABLE_MINECART, (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.MINECART); });
	}
}
