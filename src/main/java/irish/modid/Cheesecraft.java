package irish.modid;

import irish.modid.ModBlocks.ModBlocks;
import irish.modid.BlockEntities.ModBlockEntities;
import irish.modid.ModItems.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cheesecraft implements ModInitializer {
	public static String MOD_ID = "cheesecraft";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final RegistryKey COW_LOOT_TABLE = EntityType.COW.getLootTableId();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Initializes all items
		ModBlocks.initialize();
		ModItems.initialize();
		ModBlockEntities.initialize();

		//modifies the calf loot table to add calf stomach
		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			//only modifies built-in loot tables and checks if the key is correct
			if(source.isBuiltin() && COW_LOOT_TABLE.equals(key)){
				LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(ModItems.COW_STOMACH).weight(1));
				tableBuilder.pool(poolBuilder);
			}
		});
	}
}