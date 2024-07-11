package com.kittehmod.vct.util;

import javax.annotation.Nullable;

import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import oshi.util.tuples.Pair;

public class CreativeTabHelper 
{
    private static ResourceKey<CreativeModeTab> getTabWithMatchingName(ResourceLocation tabLocation, @Nullable ResourceKey<CreativeModeTab> fallbackTab) {
    	ResourceKey<CreativeModeTab> tab = null;
    	if (FMLEnvironment.dist == Dist.DEDICATED_SERVER) {
    		return null;
    	}
		if (BuiltInRegistries.CREATIVE_MODE_TAB.containsKey(tabLocation)) {
			CreativeModeTab tempTab = BuiltInRegistries.CREATIVE_MODE_TAB.get(tabLocation);
			tab = BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(tempTab).get();
		}
    	if (tab == null && fallbackTab != null) { // If for some reason the tab doesn't exist, fallback.
    		tab = fallbackTab;
    	}
    	return tab;
    }
	
    @SubscribeEvent
    public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
    	MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	// Insert crafting tables into vanilla tab.
    	if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		Item item = Items.CRAFTING_TABLE;
    		for (Pair<String, Item> pair : VCTRegistry.CRAFTING_TABLE_ITEMS) {
    			map.putAfter(item.getDefaultInstance(), pair.getB().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			item = pair.getB();
    		}
    		// Insert modded crafting tables that use vanilla tab.
    		/*if (ModList.get().isLoaded("atmospheric")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), ASPEN_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(ASPEN_CRAFTING_TABLE.getDefaultInstance(), GRIMWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(GRIMWOOD_CRAFTING_TABLE.getDefaultInstance(), KOUSA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(KOUSA_CRAFTING_TABLE.getDefaultInstance(), MORADO_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(MORADO_CRAFTING_TABLE.getDefaultInstance(), ROSEWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(ROSEWOOD_CRAFTING_TABLE.getDefaultInstance(), YUCCA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("autumnity")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), MAPLE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("caverns_and_chasms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("endergetic")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), POISE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("environmental")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), CHERRY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CHERRY_CRAFTING_TABLE.getDefaultInstance(), WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(WILLOW_CRAFTING_TABLE.getDefaultInstance(), WISTERIA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("upgrade_aquatic")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), DRIFTWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(DRIFTWOOD_CRAFTING_TABLE.getDefaultInstance(), RIVER_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("abundance")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), JACARANDA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(JACARANDA_CRAFTING_TABLE.getDefaultInstance(), REDBUD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("bayou_blues")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), CYPRESS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("enhanced_mushrooms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), BROWN_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(BROWN_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), RED_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("abundant_atmosphere")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), ASH_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("aether")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), AETHER_SKYROOT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("architects_palette")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), TWISTED_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("caupona")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), WALNUT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
	    	if (ModList.get().isLoaded("cobblemon")) {
	    		map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), APRICORN_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	}
    		if (ModList.get().isLoaded("deeperdarker")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), ASH_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("endlessbiomes")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), PENUMBRA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(PENUMBRA_CRAFTING_TABLE.getDefaultInstance(), TWISTED_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("extendedmushrooms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), POISONOUS_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(POISONOUS_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), HONEY_FUNGUS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(HONEY_FUNGUS_CRAFTING_TABLE.getDefaultInstance(), GLOWSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("fruittrees")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), FT_CHERRY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(FT_CHERRY_CRAFTING_TABLE.getDefaultInstance(), FT_CITRUS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("gardens_of_the_dead")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), SOULBLIGHT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(SOULBLIGHT_CRAFTING_TABLE.getDefaultInstance(), WHISTLECANE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("goodending")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), GE_CYPRESS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(GE_CYPRESS_CRAFTING_TABLE.getDefaultInstance(), GE_MUDDY_OAK_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("habitat")) {
    			if (ModList.get().isLoaded("quark")) { map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), FAIRY_RING_MUSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS); }
    		}
    		if (ModList.get().isLoaded("morecraft")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), NETHERWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("newworld")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), FIR_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("pyromancer")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), PYROWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(PYROWOOD_CRAFTING_TABLE.getDefaultInstance(), ROTTEN_PLANKS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("quark")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), QUARK_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(QUARK_AZALEA_CRAFTING_TABLE.getDefaultInstance(), QUARK_BLOSSOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("snowyspirits")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), GINGERBREAD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("windswept")) {
    			map.putAfter(WARPED_CRAFTING_TABLE.getDefaultInstance(), CHESTNUT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CHESTNUT_CRAFTING_TABLE.getDefaultInstance(), HOLLY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}*/
    	}
    	// Insert crafting table minecarts into vanilla tab.
    	if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		Item item = Items.FURNACE_MINECART;
    		for (Pair<String, Item> pair : VCTRegistry.CRAFTING_TABLE_MINECARTS) {
    			map.putAfter(item.getDefaultInstance(), pair.getB().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			item = pair.getB();
    		}
    		// Insert modded crafting table minecarts that use vanilla tab.
    		/*if (ModList.get().isLoaded("atmospheric")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), ASPEN_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(ASPEN_CRAFTING_TABLE_MINECART.getDefaultInstance(), GRIMWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(GRIMWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), KOUSA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(KOUSA_CRAFTING_TABLE_MINECART.getDefaultInstance(), MORADO_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(MORADO_CRAFTING_TABLE_MINECART.getDefaultInstance(), ROSEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(ROSEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), YUCCA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("autumnity")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), MAPLE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("caverns_and_chasms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("endergetic")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), POISE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("environmental")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), DARK_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(DARK_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), WILLOW_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(WILLOW_CRAFTING_TABLE_MINECART.getDefaultInstance(), WISTERIA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("upgrade_aquatic")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), DRIFTWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(DRIFTWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), RIVER_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("abundance")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), JACARANDA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(JACARANDA_CRAFTING_TABLE_MINECART.getDefaultInstance(), REDBUD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("bayou_blues")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), CYPRESS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("enhanced_mushrooms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), BROWN_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(BROWN_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), RED_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("abundant_atmosphere")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), ASH_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	    if (ModList.get().isLoaded("aether")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), AETHER_SKYROOT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("architects_palette")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TWISTED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("caupona")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), WALNUT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("cobblemon")) {
	    		map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), APRICORN_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("deeperdarker")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), ECHO_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("endlessbiomes")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), PENUMBRA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(PENUMBRA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TWISTED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("extendedmushrooms")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), POISONOUS_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(POISONOUS_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), HONEY_FUNGUS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(HONEY_FUNGUS_CRAFTING_TABLE_MINECART.getDefaultInstance(), GLOWSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("fruittrees")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), FT_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(FT_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), FT_CITRUS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("goodending")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), GE_CYPRESS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(GE_CYPRESS_CRAFTING_TABLE_MINECART.getDefaultInstance(), GE_MUDDY_OAK_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("gardens_of_the_dead")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), SOULBLIGHT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(SOULBLIGHT_CRAFTING_TABLE_MINECART.getDefaultInstance(), WHISTLECANE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("habitat")) {
    			if (ModList.get().isLoaded("quark")) { map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), FAIRY_RING_MUSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS); }
    		}
    		if (ModList.get().isLoaded("morecraft")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), NETHERWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("outer_end")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), AZURE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("newworld")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), FIR_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("pyromancer")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), PYROWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(PYROWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), ROTTEN_PLANKS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("quark")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), QUARK_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(QUARK_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), QUARK_BLOSSOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("snowyspirits")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), GINGERBREAD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModList.get().isLoaded("windswept")) {
    			map.putAfter(WARPED_CRAFTING_TABLE_MINECART.getDefaultInstance(), CHESTNUT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CHESTNUT_CRAFTING_TABLE_MINECART.getDefaultInstance(), HOLLY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}*/
    	}
    	/*if (ModList.get().isLoaded("ad_astra")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ad_astra", "ad_astra"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(AERONOS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(GLACIAN_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(STROPHAR_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ad_astra", "ad_astra"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(AERONOS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(GLACIAN_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(STROPHAR_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("ars_nouveau")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ars_nouveau", "ars_nouveau"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(ARCHWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ars_nouveau", "ars_nouveau"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(ARCHWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("biomemakeover")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("biomemakeover", "biomemakeover"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(BM_ANCIENT_OAK_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_BLIGHTED_BALSA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_SWAMP_CYPRESS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("biomemakeover", "biomemakeover"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(BM_ANCIENT_OAK_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_BLIGHTED_BALSA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_SWAMP_CYPRESS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BM_WILLOW_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("biomesoplenty")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("biomesoplenty", "biomesoplenty"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		//map.put(BOP_CHERRY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_DEAD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_FIR_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_HELLBARK_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_JACARANDA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_MAGIC_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_MAHOGANY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_PALM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_REDWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_UMBRAN_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("biomesoplenty", "biomesoplenty"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		//map.put(BOP_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_DEAD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_FIR_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_HELLBARK_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_JACARANDA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_MAGIC_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_MAHOGANY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_PALM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_REDWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_UMBRAN_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BOP_WILLOW_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("ceilands")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ceilands", "ceilands"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(CEILTRUNK_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(LUZAWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ceilands", "ceilands"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(CEILTRUNK_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(LUZAWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("colorfulazaleas")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("colorfulazaleas", "colorful_azaleas"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(AZULE_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BRIGHT_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(FISS_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ROZE_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TECAL_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TITANIUM_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(WALNUT_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("colorfulazaleas", "colorful_azaleas"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(AZULE_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(BRIGHT_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(FISS_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ROZE_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TECAL_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TITANIUM_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(WALNUT_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("darkerdepths")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("darkerdepths", "darkerdepths"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(PETRIFIED_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("darkerdepths", "darkerdepths"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(PETRIFIED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("enlightened_end")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("enlightened_end", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(CONGEALED_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(VERDANT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("enlightened_end", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(CONGEALED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(VERDANT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("ecologics")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ecologics", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(ECO_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_FLOWERING_AZALEA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_COCONUT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_WALNUT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("ecologics", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(ECO_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_FLOWERING_AZALEA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_COCONUT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ECO_WALNUT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("forbidden_arcanus")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("forbidden_arcanus", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(ARCANE_EDELWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(AURUM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(CHERRYWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(EDELWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(FUNGYSS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("forbidden_arcanus", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(ARCANE_EDELWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(AURUM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(CHERRYWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(EDELWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(FUNGYSS_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("hexcasting")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("hexcasting", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(EDIFIED_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("hexcasting", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(EDIFIED_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("hexerei")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("hexerei", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(HEXEREI_MAHOGANY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEXEREI_WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEXEREI_WITCH_HAZEL_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("hexerei", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(HEXEREI_MAHOGANY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEXEREI_WILLOW_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEXEREI_WITCH_HAZEL_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("integrateddynamics")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("integrateddynamics", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(MENRIL_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("integrateddynamics", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(MENRIL_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("malum")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("malum", "naturals_wonders"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(RUNEWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SOULWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("malum", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(RUNEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SOULWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("nethers_exoticism")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("nethers_exoticism", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(JABOTICABA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RAMBOUTAN_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("nethers_exoticism", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(JABOTICABA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RAMBOUTAN_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("phantasm")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("phantasm", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(EBONY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PREAM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("phantasm", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(EBONY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PREAM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("prehistoricfauna")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("prehistoricfauna", "decoration_tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(ARAUCARIA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEIDIPHYLLUM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(LIRIODENDRITES_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(METASEQUOIA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PROTOJUNIPEROXYLON_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PROTOPICEOXYLON_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ZAMITES_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("prehistoricfauna", "misc_tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(ARAUCARIA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(HEIDIPHYLLUM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(LIRIODENDRITES_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(METASEQUOIA_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PROTOJUNIPEROXYLON_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(PROTOPICEOXYLON_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(ZAMITES_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("regions_unexplored")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("regions_unexplored", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(RUE_BAOBAB_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_BLACKWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_BRIMWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_CYPRESS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_DEAD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_EUCALYPTUS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_JOSHUA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_LARCH_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_MAPLE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_MAUVE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_PALM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_PINE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_REDWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("regions_unexplored", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(RUE_BAOBAB_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_BLACKWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_BRIMWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_CHERRY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_CYPRESS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_DEAD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_EUCALYPTUS_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_JOSHUA_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_LARCH_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_MAPLE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_MAUVE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_PALM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_PINE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_REDWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(RUE_WILLOW_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("silentgear")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("silentgear", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(SG_NETHERWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("silentgear", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(SG_NETHERWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("tconstruct")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("tconstruct", "world"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(BLOODSHROOM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(GREENHEART_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SKYROOT_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("tconstruct", "world"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(BLOODSHROOM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(GREENHEART_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SKYROOT_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("twigs")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("twigs", "item_group"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(STRIPPED_BAMBOO_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("twigs", "item_group"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(STRIPPED_BAMBOO_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModList.get().isLoaded("twilightforest")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("twilightforest", "building_blocks"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(CANOPY_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(DARKWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TWILIGHT_MANGROVE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(MINEWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SORTINGWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TIMEWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TRANSWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TWILIGHT_OAK_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		if (ModList.get().isLoaded("tflostblocks")) { map.put(TOWERWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS); }
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("twilightforest", "tools"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(CANOPY_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(DARKWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TWILIGHT_MANGROVE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(MINEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SORTINGWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TIMEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TRANSWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(TWILIGHT_OAK_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		if (ModList.get().isLoaded("tflostblocks")) { map.put(TOWERWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS); }
    		}
    	}
    	if (ModList.get().isLoaded("undergarden")) {
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("undergarden", "tab"), CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
	    		map.put(GRONGLE_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SMOGSTEM_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(WIGGLEWOOD_CRAFTING_TABLE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (event.getTabKey() == getTabWithMatchingName(new ResourceLocation("undergarden", "tab"), CreativeModeTabs.TOOLS_AND_UTILITIES)) {
	    		map.put(GRONGLE_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(SMOGSTEM_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    		map.put(WIGGLEWOOD_CRAFTING_TABLE_MINECART.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}*/
    }
}
