package kittehmod.vct.datagen;

import kittehmod.vct.VariantCraftingTablesMod;
import kittehmod.vct.items.VCTItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class VCTItemModelProvider extends ItemModelProvider
{

	public VCTItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, VariantCraftingTablesMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		// Insert any items that need to be generated.
		basicItem(VCTItems.SPRUCE_CRAFTING_TABLE_MINECART.get());
	}

}
