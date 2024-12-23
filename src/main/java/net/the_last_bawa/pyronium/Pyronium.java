package net.the_last_bawa.pyronium;

import net.fabricmc.api.ModInitializer;

import net.the_last_bawa.pyronium.block.ModBlocks;
import net.the_last_bawa.pyronium.item.ModItems;
import net.the_last_bawa.pyronium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pyronium implements ModInitializer {
	public static final String MOD_ID = "pyronium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}