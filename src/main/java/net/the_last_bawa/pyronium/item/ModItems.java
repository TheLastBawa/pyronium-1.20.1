package net.the_last_bawa.pyronium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.the_last_bawa.pyronium.Pyronium;
import net.the_last_bawa.pyronium.block.ModBlocks;

public class ModItems
{
    public static final Item PYRONIUM_INGOT = registerItem("pyronium_ingot", new Item(new FabricItemSettings()));
    public static final Item PYRONITE_CRYSTAL = registerItem("pyronite_crystal", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(ModItems.PYRONIUM_INGOT);
        entries.add(ModItems.PYRONITE_CRYSTAL);
    }

    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(ModBlocks.PYRONIUM_BLOCK);
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(Pyronium.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        Pyronium.LOGGER.info("Registering Mod Items for " + Pyronium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksItemGroup);
    }
}
