package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class AbundanceModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public AbundanceModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("abundance");
	}

	public static class Serializer implements IConditionSerializer<AbundanceModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "abundance_mod_installed");
		}

		@Override
		public void write(JsonObject json, AbundanceModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public AbundanceModInstalledCondition read(JsonObject json) {
			return new AbundanceModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}