package com.kittehmod.vct.registry;

import com.kittehmod.vct.registry.compat.*;

import net.minecraftforge.fml.ModList;

public class VCTCompats 
{
	public static void registerCompats() {
		if (checkModLoaded("blueprint")) {
			AbnormalsCompat.registerCompat();
		}
		if (checkModLoaded("abundant_atmosphere")) {
			AbundantAtmosphereCompat.registerCompat();
		}
		if (checkModLoaded("ad_astra")) {
			AdAstraCompat.registerCompat();
		}
		if (checkModLoaded("aether")) {
			AetherCompat.registerCompat();
		}
		if (checkModLoaded("aether_redux")) {
			AetherReduxCompat.registerCompat();
		}
		if (checkModLoaded("alexscaves")) {
			AlexsCavesCompat.registerCompat();
		}
		if (checkModLoaded("architects_palette")) {
			ArchitectsPaletteCompat.registerCompat();
		}
		if (checkModLoaded("ars_nouveau")) {
			ArsNouveauCompat.registerCompat();
		}
		if (checkModLoaded("atum")) {
			AtumCompat.registerCompat();
		}
		if (checkModLoaded("better_archeology")) {
			BetterArchaeologyCompat.registerCompat();
		}
		if (checkModLoaded("bewitchment")) {
			BewitchmentCompat.registerCompat();
		}
		if (checkModLoaded("biomemakeover")) {
			BiomeMakeoverCompat.registerCompat();
		}
		if (checkModLoaded("biomesoplenty")) {
			BiomesOPlentyCompat.registerCompat();
		}
		if (checkModLoaded("bloomingnature")) {
			BloomingNatureCompat.registerCompat();
		}
		if (checkModLoaded("caupona")) {
			CauponaCompat.registerCompat();
		}
		if (checkModLoaded("ceilands")) {
			CeilandsCompat.registerCompat();
		}
		if (checkModLoaded("cobblemon")) {
			CobblemonCompat.registerCompat();
		}
		if (checkModLoaded("colorfulazaleas")) {
			ColorfulAzaleasCompat.registerCompat();
		}
		if (checkModLoaded("darkerdepths")) {
			DarkerDepthsCompat.registerCompat();
		}
		if (checkModLoaded("deepaether")) {
			DeepAetherCompat.registerCompat();
		}
		if (checkModLoaded("deeperdarker")) {
			DeeperDarkerCompat.registerCompat();
		}
		if (checkModLoaded("ecologics")) {
			EcologicsCompat.registerCompat();
		}
		if (checkModLoaded("edenring")) {
			EdenRingCompat.registerCompat();
		}
		if (checkModLoaded("eldritch_end")) {
			EldritchEndCompat.registerCompat();
		}
		if (checkModLoaded("phantasm")) {
			EndsPhantasmCompat.registerCompat();
		}
		if (checkModLoaded("endlessbiomes")) {
			EndlessBiomesCompat.registerCompat();
		}
		if (checkModLoaded("enhanced_mushrooms")) {
			EnhancedMushroomsCompat.registerCompat();
		}
		if (checkModLoaded("enlightened_end")) {
			EnlightenedEndCompat.registerCompat();
		}
		if (checkModLoaded("extendedmushrooms")) {
			ExtendedMushroomsCompat.registerCompat();
		}
		if (checkModLoaded("forbidden_arcanus")) {
			ForbiddenArcanusCompat.registerCompat();
		}
		if (checkModLoaded("fruitfulfun")) {
			FruitfulFunCompat.registerCompat();
		}
		if (checkModLoaded("gardens_of_the_dead")) {
			GardensOfTheDeadCompat.registerCompat();
		}
		if (checkModLoaded("goodending")) {
			GoodEndingCompat.registerCompat();
		}
		if (checkModLoaded("habitat")) {
			HabitatCompat.registerCompat();
		}
		if (checkModLoaded("hexcasting")) {
			HexcastingCompat.registerCompat();
		}
		if (checkModLoaded("hexerei")) {
			HexereiCompat.registerCompat();
		}
		if (checkModLoaded("horizons")) {
			HorizonsCompat.registerCompat();
		}
		if (checkModLoaded("integrateddynamics")) {
			IntegratedDynamicsCompat.registerCompat();
		}
		if (checkModLoaded("malum")) {
			MalumCompat.registerCompat();
		}
		if (checkModLoaded("minestuck")) {
			MinestuckCompat.registerCompat();
		}
		if (checkModLoaded("morecraft")) {
			MorecraftCompat.registerCompat();
		}
		if (checkModLoaded("mynethersdelight")) {
			MyNethersDelightCompat.registerCompat();
		}
		if (checkModLoaded("naturespirit")) {
			NaturesSpiritCompat.registerCompat();
		}
		if (checkModLoaded("nethers_exoticism")) {
			NethersExoticismCompat.registerCompat();
		}
		if (checkModLoaded("newworld")) {
			NewWorldCompat.registerCompat();
		}
		if (checkModLoaded("outer_end")) {
			OuterEndCompat.registerCompat();
		}
		if (checkModLoaded("prehistoricfauna")) {
			PrehistoricFaunaCompat.registerCompat();
		}
		if (checkModLoaded("pyromancer")) {
			PyromancerCompat.registerCompat();
		}
		if (checkModLoaded("quark")) {
			QuarkCompat.registerCompat();
		}
		if (checkModLoaded("regions_unexplored")) {
			RegionsUnexploredCompat.registerCompat();
		}
		if (checkModLoaded("silentgear")) {
			SilentGearCompat.registerCompat();
		}
		if (checkModLoaded("flyingstuff")) {
			SkyLandsCompat.registerCompat();
		}
		if (checkModLoaded("snowyspirit")) {
			SnowySpiritCompat.registerCompat();
		}
		if (checkModLoaded("tconstruct")) {
			TinkersConstructCompat.registerCompat();
		}
		if (checkModLoaded("twigs")) {
			TwigsCompat.registerCompat();
		}
		if (checkModLoaded("twilightforest")) {
			TwilightForestCompat.registerCompat();
		}
		if (checkModLoaded("undergarden")) {
			UndergardenCompat.registerCompat();
		}
		if (checkModLoaded("vinery")) {
			VineryCompat.registerCompat();
		}
		if (checkModLoaded("windswept")) {
			WindsweptCompat.registerCompat();
		}
	}
	
	public static boolean checkModLoaded(String modid) {
		return true; // Currently returns true until a solution for block loot can be found.
		// return ModList.get().isLoaded(modid);
	}
}
