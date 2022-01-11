package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class AutumnityModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public AutumnityModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("autumnity");
	}

	public static class Serializer implements IConditionSerializer<AutumnityModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "autumnity_mod_installed");
		}

		@Override
		public void write(JsonObject json, AutumnityModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public AutumnityModInstalledCondition read(JsonObject json) {
			return new AutumnityModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}