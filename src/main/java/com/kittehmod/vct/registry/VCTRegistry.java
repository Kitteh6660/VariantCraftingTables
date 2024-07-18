package com.kittehmod.vct.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.vct.VariantCraftingTablesMod;
import com.kittehmod.vct.blocks.VCTCraftingTableBlock;
import com.kittehmod.vct.entities.MinecartCraftingTable;
import com.kittehmod.vct.items.CraftingTableMinecartItem;
import com.kittehmod.vct.tags.VCTItemTags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegisterEvent;
import oshi.util.tuples.Pair;

public class VCTRegistry 
{
	public static final EntityType<MinecartCraftingTable> CRAFTING_TABLE_MINECART = EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, Blocks.CRAFTING_TABLE)).build("crafting_table_minecart"); 
	
	public static final List<Pair<String, Block>> CRAFTING_TABLE_BLOCKS = new ArrayList<Pair<String, Block>>();
	public static final List<Pair<String, Item>> CRAFTING_TABLE_ITEMS = new ArrayList<Pair<String, Item>>();
	public static final List<Pair<String, Item>> CRAFTING_TABLE_MINECARTS = new ArrayList<Pair<String, Item>>();
	
	public static final Item.Properties PROPERTIES = new Item.Properties();
	
	public static void registerVanilla() {
		// Add minecart for oak (vanilla) crafting table.
		CRAFTING_TABLE_MINECARTS.add(new Pair<String, Item>("oak_crafting_table_minecart", new CraftingTableMinecartItem(PROPERTIES, (CraftingTableBlock)Blocks.CRAFTING_TABLE)));
		// Add blocks
		VCTRegistry.registerCraftingTable(VCTNames.SPRUCE, Block.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.BIRCH, Block.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.JUNGLE, Block.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.ACACIA, Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.DARK_OAK, Block.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.MANGROVE, Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.CHERRY, Block.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.BAMBOO, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.BAMBOO_WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.CRIMSON, Block.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.NETHER_WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.WARPED, Block.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.NETHER_WOOD));
	}
	
	public static void registerCraftingTable(String name, Block.Properties properties) {
		CraftingTableBlock block = new VCTCraftingTableBlock(properties);
		Item blockItem = new BlockItem(block, PROPERTIES.stacksTo(64));
		Item minecartItem = new CraftingTableMinecartItem(PROPERTIES.stacksTo(1), block);
		CRAFTING_TABLE_BLOCKS.add(new Pair<String, Block>(name, block));
		CRAFTING_TABLE_ITEMS.add(new Pair<String, Item>(name, blockItem));
		CRAFTING_TABLE_MINECARTS.add(new Pair<String, Item>(name + "_minecart", minecartItem));
	}
	
	@SubscribeEvent
	public static void registerBlocksItems(RegisterEvent event) {
		event.register(Registries.BLOCK, (helper) -> {
	    	VCTRegistry.registerVanilla();
	    	VCTCompats.registerCompats();
	        for (Pair<String, Block> pair : VCTRegistry.CRAFTING_TABLE_BLOCKS) {
	        	helper.register(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, pair.getA()), pair.getB());
	        }
		});
		event.register(Registries.ITEM, (helper) -> {
	        for (Pair<String, Item> pair : VCTRegistry.CRAFTING_TABLE_ITEMS) {
	        	helper.register(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, pair.getA()), pair.getB());
	        }
	        for (Pair<String, Item> pair : VCTRegistry.CRAFTING_TABLE_MINECARTS) {
	        	helper.register(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, pair.getA()), pair.getB());
	        }
		});
		event.register(Registries.ENTITY_TYPE, (helper) -> {
			helper.register(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, "crafting_table_minecart"), CRAFTING_TABLE_MINECART);
		});
	}	
}
