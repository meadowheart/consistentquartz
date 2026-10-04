package meadowheart.consistentquartz;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.GenerationStep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsistentQuartz implements ModInitializer {
	public static final String MOD_ID = "consistentquartz";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();

		BiomeModifications.create(Identifier.fromNamespaceAndPath("consistentquartz", "main")).add(ModificationPhase.REMOVALS,
				BiomeSelectors.foundInTheNether(),
				context -> context.getGenerationSettings().removeFeature(OrePlacements.ORE_QUARTZ_NETHER)
		);
		BiomeModifications.create(Identifier.fromNamespaceAndPath("consistentquartz", "main")).add(ModificationPhase.REMOVALS,
				BiomeSelectors.foundInTheNether(),
				context -> context.getGenerationSettings().removeFeature(OrePlacements.ORE_QUARTZ_DELTAS)
		);
		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheNether(),
				GenerationStep.Decoration.UNDERGROUND_DECORATION,
				QuartzGeodePlaced.QUARTZ_GEODE_PLACED
		);

		LOGGER.info("Consistent Quartz loaded!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
