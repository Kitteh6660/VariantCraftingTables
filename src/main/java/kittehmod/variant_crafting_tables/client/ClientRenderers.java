package kittehmod.variant_crafting_tables.client;

import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.entities.VCTEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientRenderers
{
	public static void initialize() {
		RenderTypeLookup.setRenderLayer(VCTBlocks.GLOWSHROOM_CRAFTING_TABLE.get(), RenderType.translucent());
		
		RenderingRegistry.registerEntityRenderingHandler(VCTEntities.CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() { 
			@Override 
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
	}
}
