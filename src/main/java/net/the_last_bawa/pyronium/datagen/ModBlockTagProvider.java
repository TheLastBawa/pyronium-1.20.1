package net.the_last_bawa.pyronium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.the_last_bawa.pyronium.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PYRONIUM_BLOCK)
                .add(ModBlocks.PYRONITE_ORE)
                .add(ModBlocks.DEEPSLATE_PYRONITE_ORE)
                .add(ModBlocks.NETHER_PYRONITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PYRONIUM_BLOCK)
                .add(ModBlocks.PYRONITE_ORE)
                .add(ModBlocks.DEEPSLATE_PYRONITE_ORE)
                .add(ModBlocks.NETHER_PYRONITE_ORE);
    }
}
