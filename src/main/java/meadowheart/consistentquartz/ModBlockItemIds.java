package meadowheart.consistentquartz;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {
    public static final BlockItemId BUDDING_QUARTZ = create("budding_quartz");
    public static final BlockItemId AMETHYST_BRICKS = create("amethyst_bricks");
    public static final BlockItemId AMETHYST_PILLAR = create("amethyst_pillar");
    public static final BlockItemId AMETHYST_SLAB = create("amethyst_slab");
    public static final BlockItemId AMETHYST_STAIRS = create("amethyst_stairs");
    public static final BlockItemId CHISELED_AMETHYST_BLOCK = create("chiseled_amethyst_block");
    public static final BlockItemId LARGE_QUARTZ_BUD = create("large_quartz_bud");
    public static final BlockItemId MEDIUM_QUARTZ_BUD = create("medium_quartz_bud");
    public static final BlockItemId POLISHED_AMETHYST = create("polished_amethyst");
    public static final BlockItemId POLISHED_AMETHYST_SLAB = create("polished_amethyst_slab");
    public static final BlockItemId POLISHED_AMETHYST_STAIRS = create("polished_amethyst_stairs");
    public static final BlockItemId QUARTZ_CLUSTER = create("quartz_cluster");
    public static final BlockItemId QUARTZ_CRYSTAL_BLOCK = create("quartz_crystal_block");
    public static final BlockItemId QUARTZ_CRYSTAL_SLAB = create("quartz_crystal_slab");
    public static final BlockItemId QUARTZ_CRYSTAL_STAIRS = create("quartz_crystal_stairs");
    public static final BlockItemId SMALL_QUARTZ_BUD = create("small_quartz_bud");
    public static final BlockItemId SMOOTH_AMETHYST = create("smooth_amethyst");
    public static final BlockItemId SMOOTH_AMETHYST_SLAB = create("smooth_amethyst_slab");
    public static final BlockItemId SMOOTH_AMETHYST_STAIRS = create("smooth_amethyst_stairs");

    private static BlockItemId create(String name) {
        Identifier id = ConsistentQuartz.id(name);
        return BlockItemId.create(id, id);
    }
}
