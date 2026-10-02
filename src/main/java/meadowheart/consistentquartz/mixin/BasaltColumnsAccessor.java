package meadowheart.consistentquartz.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BasaltColumnsFeature.class)
public interface BasaltColumnsAccessor {
    @Accessor("CANNOT_PLACE_ON")
    static ImmutableList<Block> getCANNOT_PLACE_ON() {
        throw new AssertionError("Untransformed @Accessor");
    }
    @Accessor("CANNOT_PLACE_ON")
    @Mutable
    static void setCANNOT_PLACE_ON(ImmutableList<Block> cannotPlaceOn) {}
}