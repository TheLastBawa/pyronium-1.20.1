package net.the_last_bawa.pyronium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.the_last_bawa.pyronium.Pyronium;

public class ModBlocks
{

    public static final Block PYRONIUM_BLOCK = registerBlock("pyronium_block",
            new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).mapColor(MapColor.BRIGHT_RED).hardness((float) 2.8F)
                    .resistance(6.0F).requiresTool()));

    public static final Block PYRONITE_ORE = registerBlock("pyronite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0F), UniformIntProvider.create(1, 3)));

    public static final Block DEEPSLATE_PYRONITE_ORE = registerBlock("deepslate_pyronite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).hardness(4.0F), UniformIntProvider.create(1, 3)));

    public static final Block NETHER_PYRONITE_ORE = registerBlock("nether_pyronite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).hardness(1.0F), UniformIntProvider.create(1, 3)));


    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pyronium.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(Pyronium.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks()
    {
        Pyronium.LOGGER.info("Registering Mod Blocks for " + Pyronium.MOD_ID);
    }
}
