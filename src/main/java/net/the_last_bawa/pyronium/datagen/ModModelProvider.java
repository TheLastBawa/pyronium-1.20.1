package net.the_last_bawa.pyronium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.the_last_bawa.pyronium.block.ModBlocks;
import net.the_last_bawa.pyronium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PYRONIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PYRONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PYRONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PYRONITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.PYRONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PYRONITE_CRYSTAL, Models.GENERATED);
    }
}
