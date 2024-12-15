package net.the_last_bawa.pyronium.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.the_last_bawa.pyronium.Pyronium;

import java.util.List;

public class ModPlacedFeatures
{

    public static final RegistryKey<PlacedFeature> PYRONITE_ORE_PLACED_KEY = registerKey("pyronite_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_PYRONITE_ORE_PLACED_KEY = registerKey("nether_pyronite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PYRONITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PYRONITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(60, //Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, NETHER_PYRONITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_PYRONITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(60, //Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(118))));
    }

public static RegistryKey<PlacedFeature> registerKey(String name)
{
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Pyronium.MOD_ID, name));
}

private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                             List<PlacementModifier> modifiers)
{
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
}
}