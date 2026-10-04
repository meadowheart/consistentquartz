package meadowheart.consistentquartz.client.datagen;

import meadowheart.consistentquartz.QuartzGeodeFeature;
import meadowheart.consistentquartz.QuartzGeodePlaced;
import meadowheart.consistentquartz.WorldGenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ConsistentQuartzDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WorldGenProvider::new);
    }
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.FEATURE, QuartzGeodeFeature::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, QuartzGeodePlaced::configure);
    }
}