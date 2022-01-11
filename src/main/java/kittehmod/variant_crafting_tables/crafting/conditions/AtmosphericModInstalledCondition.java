package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class AtmosphericModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public AtmosphericModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("atmospheric");
	}

	public static class Serializer implements IConditionSerializer<AtmosphericModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "atmospheric_mod_installed");
		}

		@Override
		public void write(JsonObject json, AtmosphericModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public AtmosphericModInstalledCondition read(JsonObject json) {
			return new AtmosphericModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}