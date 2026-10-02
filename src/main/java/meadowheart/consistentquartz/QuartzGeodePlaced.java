package meadowheart.consistentquartz;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class QuartzGeodePlaced {
    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        List<PlacementModifier> quartzGeodeModifiers = List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.belowTop(6)),
                BiomeFilter.biome()
        );
        context.register(
                QUARTZ_GEODE_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(QuartzGeodeConfigured.QUARTZ_GEODE),
                        quartzGeodeModifiers
                )
        );
    }
    public static final ResourceKey<PlacedFeature> QUARTZ_GEODE_PLACED =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    ConsistentQuartz.id("quartz_geode")
            );
}
