package com.kittehmod.vct.registry;

import com.kittehmod.vct.registry.compat.*;

import net.minecraftforge.fml.ModList;

public class VCTCompats 
{
	public static void registerCompats() {
		if (ModList.get().isLoaded("blueprint")) {
			AbnormalsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("abundant_atmosphere")) {
			AbundantAtmosphereCompat.registerCompat();
		}
		if (ModList.get().isLoaded("ad_astra")) {
			AdAstraCompat.registerCompat();
		}
		if (ModList.get().isLoaded("aether")) {
			AetherCompat.registerCompat();
		}
		if (ModList.get().isLoaded("aether_redux")) {
			AetherReduxCompat.registerCompat();
		}
		if (ModList.get().isLoaded("alexscaves")) {
			AlexsCavesCompat.registerCompat();
		}
		if (ModList.get().isLoaded("architects_palette")) {
			ArchitectsPaletteCompat.registerCompat();
		}
		if (ModList.get().isLoaded("ars_nouveau")) {
			ArsNouveauCompat.registerCompat();
		}
		if (ModList.get().isLoaded("atum")) {
			AtumCompat.registerCompat();
		}
		if (ModList.get().isLoaded("better_archeology")) {
			BetterArchaeologyCompat.registerCompat();
		}
		if (ModList.get().isLoaded("biomemakeover")) {
			BiomeMakeoverCompat.registerCompat();
		}
		if (ModList.get().isLoaded("biomesoplenty")) {
			BiomesOPlentyCompat.registerCompat();
		}
		if (ModList.get().isLoaded("bloomingnature")) {
			BloomingNatureCompat.registerCompat();
		}
		if (ModList.get().isLoaded("caupona")) {
			CauponaCompat.registerCompat();
		}
		if (ModList.get().isLoaded("ceilands")) {
			CeilandsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("cobblemon")) {
			CobblemonCompat.registerCompat();
		}
		if (ModList.get().isLoaded("colorfulazaleas")) {
			ColorfulAzaleasCompat.registerCompat();
		}
		if (ModList.get().isLoaded("darkerdepths")) {
			DarkerDepthsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("deepaether")) {
			DeepAetherCompat.registerCompat();
		}
		if (ModList.get().isLoaded("deeperdarker")) {
			DeeperDarkerCompat.registerCompat();
		}
		if (ModList.get().isLoaded("ecologics")) {
			EcologicsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("edenring")) {
			EdenRingCompat.registerCompat();
		}
		if (ModList.get().isLoaded("eldritch_end")) {
			EldritchEndCompat.registerCompat();
		}
		if (ModList.get().isLoaded("phantasm")) {
			EndsPhantasmCompat.registerCompat();
		}
		if (ModList.get().isLoaded("endlessbiomes")) {
			EndlessBiomesCompat.registerCompat();
		}
		if (ModList.get().isLoaded("enhanced_mushrooms")) {
			EnhancedMushroomsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("enlightened_end")) {
			EnlightenedEndCompat.registerCompat();
		}
		if (ModList.get().isLoaded("extendedmushrooms")) {
			ExtendedMushroomsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("forbidden_arcanus")) {
			ForbiddenArcanusCompat.registerCompat();
		}
		if (ModList.get().isLoaded("fruitfulfun")) {
			FruitfulFunCompat.registerCompat();
		}
		if (ModList.get().isLoaded("gardens_of_the_dead")) {
			GardensOfTheDeadCompat.registerCompat();
		}
		if (ModList.get().isLoaded("goodending")) {
			GoodEndingCompat.registerCompat();
		}
		if (ModList.get().isLoaded("habitat")) {
			HabitatCompat.registerCompat();
		}
		if (ModList.get().isLoaded("hexcasting")) {
			HexcastingCompat.registerCompat();
		}
		if (ModList.get().isLoaded("hexerei")) {
			HexereiCompat.registerCompat();
		}
		if (ModList.get().isLoaded("horizons")) {
			HorizonsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("integrateddynamics")) {
			IntegratedDynamicsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("malum")) {
			MalumCompat.registerCompat();
		}
		if (ModList.get().isLoaded("minestuck")) {
			MinestuckCompat.registerCompat();
		}
		if (ModList.get().isLoaded("morecraft")) {
			MorecraftCompat.registerCompat();
		}
		if (ModList.get().isLoaded("mynethersdelight")) {
			MyNethersDelightCompat.registerCompat();
		}
		if (ModList.get().isLoaded("naturespirit")) {
			NaturesSpiritCompat.registerCompat();
		}
		if (ModList.get().isLoaded("nethers_exoticism")) {
			NethersExoticismCompat.registerCompat();
		}
		if (ModList.get().isLoaded("newworld")) {
			NewWorldCompat.registerCompat();
		}
		if (ModList.get().isLoaded("outer_end")) {
			OuterEndCompat.registerCompat();
		}
		if (ModList.get().isLoaded("prehistoricfauna")) {
			PrehistoricFaunaCompat.registerCompat();
		}
		if (ModList.get().isLoaded("pyromancer")) {
			PyromancerCompat.registerCompat();
		}
		if (ModList.get().isLoaded("quark")) {
			QuarkCompat.registerCompat();
		}
		if (ModList.get().isLoaded("regions_unexplored")) {
			RegionsUnexploredCompat.registerCompat();
		}
		if (ModList.get().isLoaded("silentgear")) {
			SilentGearCompat.registerCompat();
		}
		if (ModList.get().isLoaded("flyingstuff")) {
			SkyLandsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("snowyspirit")) {
			SnowySpiritCompat.registerCompat();
		}
		if (ModList.get().isLoaded("tconstruct")) {
			TinkersConstructCompat.registerCompat();
		}
		if (ModList.get().isLoaded("twigs")) {
			TwigsCompat.registerCompat();
		}
		if (ModList.get().isLoaded("twilightforest")) {
			TwilightForestCompat.registerCompat();
		}
		if (ModList.get().isLoaded("undergarden")) {
			UndergardenCompat.registerCompat();
		}
		if (ModList.get().isLoaded("vinery")) {
			VineryCompat.registerCompat();
		}
		if (ModList.get().isLoaded("windswept")) {
			WindsweptCompat.registerCompat();
		}
	}
}
