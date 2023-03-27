package kittehmod.vct.datagen;

import kittehmod.vct.VariantCraftingTablesMod;
import kittehmod.vct.blocks.VCTBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class VCTBlockStateProvider extends BlockStateProvider
{

	public VCTBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, VariantCraftingTablesMod.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		craftingTable(VCTBlocks.SPRUCE_CRAFTING_TABLE.get(), "block/spruce_crafting_table", "minecraft:block/spruce_planks");
	}
    
    private void craftingTable(Block block, String tableTexture, String bottomTexture) {
		ModelFile model = models().withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), ModelProvider.BLOCK_FOLDER + "/cube_all").texture("north", tableTexture + "_front").texture("west", tableTexture + "_front").texture("south", tableTexture + "_side").texture("east", tableTexture + "_side").texture("up", tableTexture + "_top").texture("down", bottomTexture);
    	getVariantBuilder(block).forAllStates((state) -> {
    		return ConfiguredModel.builder().modelFile(model).build();
    	});
		itemModels().getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath()).parent(model);

    }
}
