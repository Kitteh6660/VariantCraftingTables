package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class BayouBluesModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public BayouBluesModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("bayou_blues");
	}

	public static class Serializer implements IConditionSerializer<BayouBluesModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "bayou_blues_mod_installed");
		}

		@Override
		public void write(JsonObject json, BayouBluesModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public BayouBluesModInstalledCondition read(JsonObject json) {
			return new BayouBluesModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}