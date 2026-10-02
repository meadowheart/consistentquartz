package meadowheart.consistentquartz.client.datagen;

import meadowheart.consistentquartz.QuartzGeodeConfigured;
import meadowheart.consistentquartz.QuartzGeodePlaced;
import meadowheart.consistentquartz.WorldGenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
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
        registryBuilder.add(Registries.CONFIGURED_FEATURE, QuartzGeodeConfigured::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, QuartzGeodePlaced::configure);
    }
}