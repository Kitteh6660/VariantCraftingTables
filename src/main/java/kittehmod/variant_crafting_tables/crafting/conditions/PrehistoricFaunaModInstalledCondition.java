package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class PrehistoricFaunaModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public PrehistoricFaunaModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("prehistoricfauna");
	}

	public static class Serializer implements IConditionSerializer<PrehistoricFaunaModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "prehistoric_fauna_mod_installed");
		}

		@Override
		public void write(JsonObject json, PrehistoricFaunaModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public PrehistoricFaunaModInstalledCondition read(JsonObject json) {
			return new PrehistoricFaunaModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}