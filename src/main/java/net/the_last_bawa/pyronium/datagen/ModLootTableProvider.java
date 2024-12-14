package net.the_last_bawa.pyronium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.the_last_bawa.pyronium.block.ModBlocks;
import net.the_last_bawa.pyronium.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.PYRONIUM_BLOCK);

        addDrop(ModBlocks.PYRONITE_ORE, oreDrops(ModBlocks.PYRONITE_ORE, ModItems.PYRONITE_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_PYRONITE_ORE, oreDrops(ModBlocks.DEEPSLATE_PYRONITE_ORE, ModItems.PYRONITE_CRYSTAL));
        addDrop(ModBlocks.NETHER_PYRONITE_ORE, oreDrops(ModBlocks.NETHER_PYRONITE_ORE, ModItems.PYRONITE_CRYSTAL));
    }
}
