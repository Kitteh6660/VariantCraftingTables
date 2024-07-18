package com.kittehmod.vct.datagen;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootDataId;
import net.minecraft.world.level.storage.loot.LootDataType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;

public class VCTLootTableProvider extends LootTableProvider
{
	private final List<LootTableProvider.SubProviderEntry> subProviders;
	
	public VCTLootTableProvider(PackOutput output, Set<ResourceLocation> set, List<SubProviderEntry> list) {
		super(output, set, list);
		this.subProviders = list;
	}

	@Override
	public List<LootTableProvider.SubProviderEntry> getTables() {
		return subProviders;
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
		map.forEach((resourceLocation, lootTable) -> lootTable.validate(validationContext.setParams(lootTable.getParamSet()).enterElement("{" + resourceLocation + "}", new LootDataId<>(LootDataType.TABLE, resourceLocation))));
	}
}
