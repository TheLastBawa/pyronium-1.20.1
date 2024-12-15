package net.the_last_bawa.pyronium.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.the_last_bawa.pyronium.Pyronium;
import net.the_last_bawa.pyronium.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures
{

    public static final RegistryKey<ConfiguredFeature<?, ?>> PYRONITE_ORE_KEY = registerKey("pyronite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PYRONITE_ORE_KEY = registerKey("nether_pyronite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldPyroniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.PYRONITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_PYRONITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherPyroniteOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_PYRONITE_ORE.getDefaultState()));

        register(context, PYRONITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPyroniteOres, 5));
        register(context, NETHER_PYRONITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPyroniteOres, 5));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Pyronium.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
        {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
    }
