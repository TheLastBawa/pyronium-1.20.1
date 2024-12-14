package net.the_last_bawa.pyronium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.the_last_bawa.pyronium.block.ModBlocks;
import net.the_last_bawa.pyronium.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> PYRONITE_SMELTABLES = List.of(ModBlocks.PYRONITE_ORE,
            ModBlocks.DEEPSLATE_PYRONITE_ORE, ModBlocks.NETHER_PYRONITE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter)
    {
        offerSmelting(exporter, PYRONITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRONITE_CRYSTAL,
                0.7f, 200, "pyronite");
        offerBlasting(exporter, PYRONITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRONITE_CRYSTAL,
                0.7f, 100, "pyronite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PYRONIUM_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYRONIUM_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PYRONIUM_INGOT, 1)
                .input(ModItems.PYRONITE_CRYSTAL)
                .input(Items.COPPER_INGOT)
                .input(Items.COPPER_INGOT)
                .input(Items.COPPER_INGOT)
                .input(Items.COPPER_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.PYRONITE_CRYSTAL), conditionsFromItem(ModItems.PYRONITE_CRYSTAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PYRONITE_CRYSTAL)));
    }
}
