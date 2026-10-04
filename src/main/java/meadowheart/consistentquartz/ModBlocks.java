package meadowheart.consistentquartz;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.AMETHYST_BLOCK;

public class ModBlocks {
    public static final Block AMETHYST_SLAB = register(
            ModBlockItemIds.AMETHYST_SLAB,
            AmethystSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(AMETHYST_BLOCK)
    );
    public static final Block AMETHYST_STAIRS = register(
            ModBlockItemIds.AMETHYST_STAIRS,
            AmethystStairBlock::new,
            BlockBehaviour.Properties.ofFullCopy(AMETHYST_BLOCK)
    );
    public static final Block QUARTZ_CRYSTAL_BLOCK = register(
            ModBlockItemIds.QUARTZ_CRYSTAL_BLOCK,
            AmethystBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    public static final Block QUARTZ_CRYSTAL_SLAB = register(
            ModBlockItemIds.QUARTZ_CRYSTAL_SLAB,
            AmethystSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(QUARTZ_CRYSTAL_BLOCK)
    );
    public static final Block QUARTZ_CRYSTAL_STAIRS = register(
            ModBlockItemIds.QUARTZ_CRYSTAL_STAIRS,
            AmethystStairBlock::new,
            BlockBehaviour.Properties.ofFullCopy(QUARTZ_CRYSTAL_BLOCK)
    );
    public static final Block BUDDING_QUARTZ = register(
            ModBlockItemIds.BUDDING_QUARTZ,
            BuddingQuartzBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.POPPED)
    );
    public static final Block QUARTZ_CLUSTER = register(
            ModBlockItemIds.QUARTZ_CLUSTER,
            (p) -> new AmethystClusterBlock(4.0F, 8.0F, p),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel((_) -> 5).pushReaction(PushReaction.POPPED)
    );
    public static final Block LARGE_QUARTZ_BUD = register(
            ModBlockItemIds.LARGE_QUARTZ_BUD,
            (p) -> new AmethystClusterBlock(3.0F, 8.0F, p),
            BlockBehaviour.Properties.ofFullCopy(QUARTZ_CLUSTER).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((_) -> 4)
    );
    public static final Block MEDIUM_QUARTZ_BUD = register(
            ModBlockItemIds.MEDIUM_QUARTZ_BUD,
            (p) -> new AmethystClusterBlock(2.0F, 8.0F, p),
            BlockBehaviour.Properties.ofFullCopy(QUARTZ_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((_) -> 2)
    );
    public static final Block SMALL_QUARTZ_BUD = register(
            ModBlockItemIds.SMALL_QUARTZ_BUD,
            (p) -> new AmethystClusterBlock(1.0F, 8.0F, p),
            BlockBehaviour.Properties.ofFullCopy(QUARTZ_CLUSTER).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((_) -> 1)
    );
    public static final Block POLISHED_AMETHYST = register(
            ModBlockItemIds.POLISHED_AMETHYST,
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)
    );
    public static final Block POLISHED_AMETHYST_SLAB = register(
            ModBlockItemIds.POLISHED_AMETHYST_SLAB,
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_AMETHYST)
    );
    public static final Block POLISHED_AMETHYST_STAIRS = register(
            ModBlockItemIds.POLISHED_AMETHYST_STAIRS,
            (p) -> new StairBlock(POLISHED_AMETHYST.defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(POLISHED_AMETHYST)
    );
    public static final Block AMETHYST_BRICKS = register(
            ModBlockItemIds.AMETHYST_BRICKS,
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)
    );
    public static final Block AMETHYST_PILLAR = register(
            ModBlockItemIds.AMETHYST_PILLAR,
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)
    );
    public static final Block CHISELED_AMETHYST_BLOCK = register(
            ModBlockItemIds.CHISELED_AMETHYST_BLOCK,
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)
    );
    public static final Block SMOOTH_AMETHYST = register(
            ModBlockItemIds.SMOOTH_AMETHYST,
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)
    );
    public static final Block SMOOTH_AMETHYST_SLAB = register(
            ModBlockItemIds.SMOOTH_AMETHYST_SLAB,
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(SMOOTH_AMETHYST)
    );
    public static final Block SMOOTH_AMETHYST_STAIRS = register(
            ModBlockItemIds.SMOOTH_AMETHYST_STAIRS,
            (p) -> new StairBlock(SMOOTH_AMETHYST.defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(SMOOTH_AMETHYST)
    );

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);
        return block;
    }

    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = blockFactory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.QUARTZ_CRYSTAL_BLOCK.asItem());
            creativeTab.accept(ModBlocks.QUARTZ_CRYSTAL_STAIRS.asItem());
            creativeTab.accept(ModBlocks.QUARTZ_CRYSTAL_SLAB.asItem());
            creativeTab.accept(ModBlocks.AMETHYST_STAIRS.asItem());
            creativeTab.accept(ModBlocks.AMETHYST_SLAB.asItem());
            creativeTab.accept(ModBlocks.POLISHED_AMETHYST.asItem());
            creativeTab.accept(ModBlocks.POLISHED_AMETHYST_STAIRS.asItem());
            creativeTab.accept(ModBlocks.POLISHED_AMETHYST_SLAB.asItem());
            creativeTab.accept(ModBlocks.CHISELED_AMETHYST_BLOCK.asItem());
            creativeTab.accept(ModBlocks.AMETHYST_BRICKS.asItem());
            creativeTab.accept(ModBlocks.AMETHYST_PILLAR.asItem());
            creativeTab.accept(ModBlocks.SMOOTH_AMETHYST.asItem());
            creativeTab.accept(ModBlocks.SMOOTH_AMETHYST_STAIRS.asItem());
            creativeTab.accept(ModBlocks.SMOOTH_AMETHYST_SLAB.asItem());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.QUARTZ_CRYSTAL_BLOCK.asItem());
            creativeTab.accept(ModBlocks.BUDDING_QUARTZ.asItem());
            creativeTab.accept(ModBlocks.QUARTZ_CLUSTER.asItem());
            creativeTab.accept(ModBlocks.LARGE_QUARTZ_BUD.asItem());
            creativeTab.accept(ModBlocks.MEDIUM_QUARTZ_BUD.asItem());
            creativeTab.accept(ModBlocks.SMALL_QUARTZ_BUD.asItem());
        });
    }
}