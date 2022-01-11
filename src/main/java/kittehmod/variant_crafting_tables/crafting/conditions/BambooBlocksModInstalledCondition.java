package kittehmod.variant_crafting_tables.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class BambooBlocksModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public BambooBlocksModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("bamboo_blocks");
	}

	public static class Serializer implements IConditionSerializer<BambooBlocksModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "bamboo_blocks_mod_installed");
		}

		@Override
		public void write(JsonObject json, BambooBlocksModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public BambooBlocksModInstalledCondition read(JsonObject json) {
			return new BambooBlocksModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}