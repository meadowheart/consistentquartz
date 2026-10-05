# Consistent Quartz

Amethyst is a violet variety of quartz. So why is it that in Minecraft, they seem to be completely different things? I think that if Minecraft came out today, then amethyst and quartz would be much more consistent; they would generate in the same way, and they would have similar uses. This bothered me enough that I decided to learn Fabric API to change it!

## Features
Consistent Quartz and Amethyst (internally named "consistentquartz") gives amethyst a full decorative block set and replaces Nether quartz ore with quartz geodes. If you've ever thought that Minecraft needs more purple building blocks, this mod gives you a lot of options!

Quartz geodes generate in all Nether biomes, with a 20% chance to generate a geode for every chunk. Quartz geodes are very common, but if you're having trouble finding one, look in the Nether Wastes - they stand out against the simple terrain.

Budding quartz functions identically to budding amethyst, having a chance to grow a quartz bud every tick. Like budding amethyst, budding quartz is unobtainable in Survival.

Quartz buds have 4 growth stages, and they glow with the same level of brightness as their amethyst counterparts. Quartz clusters drop Nether quartz, which can be used to craft quartz crystal blocks, just like how amethyst blocks are crafted from 4 amethyst shards.

The vanilla block of quartz can now be crafted from 4 quartz crystal blocks instead of Nether quartz. Crafting 4 amethyst crystal blocks will give you polished amethyst. "Amethyst crystal block" is the new name for block of amethyst. Block of quartz is also renamed to "polished quartz," and its slabs and stairs are now "polished quartz slabs" and "polished quartz stairs." These renames are for the sake of consistency and to make differentiating all the new blocks a bit easier.

Both of the crystal blocks also have slab and stair variants. All of the new crystal blocks, including the slabs and stairs, make amethyst chime sounds when you interact with them.

The rest of the blocks added by the mod are simply purple amethyst variants of the quartz block set. See the gallery for a showcase of all the new blocks. I chose a color for them that I think matches well with the other purple blocks in the game, while making sure they don't look too much like Purpur.

In addition to the new blocks, I've also added a crafting recipe to convert crystal blocks back into amethyst shards or Nether quartz!

### Known Issues
In Basalt Deltas, geodes may generate with a delta (lava pool) inside of or on top of them. I was able to fix a similar problem with basalt pillars by just adding all the blocks inside a quartz geode to their "CANNOT_PLACE_ON" list, but because deltas don't already have a check for disallowed blocks like basalt pillars do, and they always come last in world generation, I don't have an easy solution for them. It's not a huge issue, so I've left it alone for now.

## Future Plans
- More version support
- More unique textures for the amethyst block set
- Config option to add back Nether quartz ore to world generation
- A dedicated Creative menu (currently, the blocks can be found in Building Blocks and Natural Blocks)

### Neoforge?
I have lots of other ideas for mods that I want to work on before anything else. I'd like to make a version for Neoforge at some point, but I can't make any promises of when. Sinytra Connector should work in the meantime.

### Mod Compatibility?
Consistent Quartz and Amethyst should be compatible with pretty much any mod, as long as it doesn't have conflicting recipes. If you find any mod incompatibilities, please open an issue and I'll look at it when I have time.

You're welcome to include Consistent Quartz and Amethyst in modpacks!
