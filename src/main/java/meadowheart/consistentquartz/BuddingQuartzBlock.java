package meadowheart.consistentquartz;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import static net.minecraft.world.level.block.BuddingAmethystBlock.canClusterGrowAtState;

public class BuddingQuartzBlock extends AmethystBlock {
    public static final MapCodec<BuddingQuartzBlock> CODEC = simpleCodec(BuddingQuartzBlock::new);
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public MapCodec<BuddingQuartzBlock> codec() {
        return CODEC;
    }

    public BuddingQuartzBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected void randomTick(final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {
        if (random.nextInt(5) == 0) {
            Direction growDirection = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos growPos = pos.relative(growDirection);
            BlockState relativeState = level.getBlockState(growPos);
            Block nextStage = null;
            if (canClusterGrowAtState(relativeState)) {
                nextStage = ModBlocks.SMALL_QUARTZ_BUD;
            } else if (relativeState.is(ModBlocks.SMALL_QUARTZ_BUD) && relativeState.getValue(AmethystClusterBlock.FACING) == growDirection) {
                nextStage = ModBlocks.MEDIUM_QUARTZ_BUD;
            } else if (relativeState.is(ModBlocks.MEDIUM_QUARTZ_BUD) && relativeState.getValue(AmethystClusterBlock.FACING) == growDirection) {
                nextStage = ModBlocks.LARGE_QUARTZ_BUD;
            } else if (relativeState.is(ModBlocks.LARGE_QUARTZ_BUD) && relativeState.getValue(AmethystClusterBlock.FACING) == growDirection) {
                nextStage = ModBlocks.QUARTZ_CLUSTER;
            }

            if (nextStage != null) {
                BlockState targetState = (BlockState)((BlockState)nextStage.defaultBlockState().setValue(AmethystClusterBlock.FACING, growDirection)).setValue(AmethystClusterBlock.WATERLOGGED, relativeState.getFluidState().is(Fluids.WATER));
                level.setBlockAndUpdate(growPos, targetState);
            }
        }
    }
}