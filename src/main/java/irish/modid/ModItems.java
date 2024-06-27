package irish.modid;

import irish.modid.ModBlocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //all items
    public static final Item AGED_CHEESE_WEDGE = new Item(ModItemSettings.AGED_CHEESE_WEDGE);
    public static final Item CHEESE_CURDS = new Item(ModItemSettings.CHEESE_CURDS);
    public static final Item CHEESE_WEDGE = new Item(ModItemSettings.CHEESE_WEDGE);
    public static final Item CALF_STOMACH = new Item(ModItemSettings.CALF_STOMACH);
    public static final Item RENNET = new Item(ModItemSettings.RENNET);
    public static final Item SALT = new Item(ModItemSettings.SALT);

    //all block items
    public static final BlockItem AGED_CHEESE_WHEEL = new BlockItem(ModBlocks.AGED_CHEESE_WHEEL_BLOCK, (ModItemSettings.AGED_CHEESE_WHEEL));
    public static final BlockItem CHEESE_WHEEL = new BlockItem(ModBlocks.CHEESE_WHEEL_BLOCK, (ModItemSettings.CHEESE_WHEEL));
    public static final BlockItem FRESH_CHEESE_WHEEL = new BlockItem(ModBlocks.FRESH_CHEESE_WHEEL_BLOCK, (ModItemSettings.FRESH_CHEESE_WHEEL));
    public static final BlockItem SALT_BLOCK = new BlockItem(ModBlocks.SALT_BLOCK_BLOCK, (ModItemSettings.SALT_BLOCK));
    public static final BlockItem CASK = new BlockItem(ModBlocks.CASK_BLOCK, (ModItemSettings.CASK));

    public static void initialize(){
        //registers all items
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "aged_cheese_wedge"), AGED_CHEESE_WEDGE);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "aged_cheese_wheel"), AGED_CHEESE_WHEEL);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "calf_stomach"), CALF_STOMACH);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "calf_stomach"), CASK);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "cheese_curds"), CHEESE_CURDS);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "cheese_wedge"), CHEESE_WEDGE);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "cheese_wheel"), CHEESE_WHEEL);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "fresh_cheese_wheel"), FRESH_CHEESE_WHEEL);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "rennet"), RENNET);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "salt"), SALT);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "salt_block"), SALT_BLOCK);

        //adds all items to groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(Items.PUMPKIN_PIE,CHEESE_WEDGE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CHEESE_WEDGE, FRESH_CHEESE_WHEEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CHEESE_WEDGE,CHEESE_WHEEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CHEESE_WHEEL, AGED_CHEESE_WEDGE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(AGED_CHEESE_WEDGE, AGED_CHEESE_WHEEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(AGED_CHEESE_WHEEL, CHEESE_CURDS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CHEESE_CURDS, FRESH_CHEESE_WHEEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(FRESH_CHEESE_WHEEL, CALF_STOMACH));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CALF_STOMACH, RENNET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(RENNET, SALT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(SALT, SALT_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(SALT_BLOCK, CASK));
    }
}
