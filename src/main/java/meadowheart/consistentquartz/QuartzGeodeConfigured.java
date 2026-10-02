package meadowheart.consistentquartz;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class QuartzGeodeConfigured {
    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        context.register(
                QUARTZ_GEODE,
                new ConfiguredFeature<>(
                        Feature.GEODE,
                        new GeodeConfiguration(
                                new GeodeBlockSettings(
                                        BlockStateProvider.simple(Blocks.AIR),
                                        BlockStateProvider.simple(ModBlocks.QUARTZ_CRYSTAL_BLOCK),
                                        BlockStateProvider.simple(ModBlocks.BUDDING_QUARTZ),
                                        BlockStateProvider.simple(Blocks.CALCITE),
                                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                                        List.of(ModBlocks.SMALL_QUARTZ_BUD.defaultBlockState(),
                                                ModBlocks.MEDIUM_QUARTZ_BUD.defaultBlockState(),
                                                ModBlocks.LARGE_QUARTZ_BUD.defaultBlockState(),
                                                ModBlocks.QUARTZ_CLUSTER.defaultBlockState()
                                        ),
                                        blocks.getOrThrow(BlockTags.FEATURES_CANNOT_REPLACE),
                                        blocks.getOrThrow(BlockTags.GEODE_INVALID_BLOCKS)),
                                new GeodeLayerSettings(
                                        1.7,
                                        2.2,
                                        3.2,
                                        4.2
                                ),
                                new GeodeCrackSettings(
                                        0.95,
                                        (double) 2.0F,
                                        2
                                ),
                                0.35,
                                0.083,
                                true,
                                UniformInt.of(4, 6),
                                UniformInt.of(3, 4),
                                UniformInt.of(1, 2),
                                -16,
                                16,
                                0.05,
                                1
                        )
                )
        );
    }
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_GEODE =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    ConsistentQuartz.id("quartz_geode")
            );
}
