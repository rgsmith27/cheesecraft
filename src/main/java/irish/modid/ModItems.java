package irish.modid;

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
    private static final Item CHEESE_WEDGE = new Item(ModItemSettings.CHEESE_WEDGE);

    //all block items
    private static final BlockItem CHEESE_WHEEL = new BlockItem(ModBlocks.CHEESE_WHEEL, (ModItemSettings.CHEESE_WHEEL));

    public static void initialize(){
        //registers all items
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "cheese_wedge"), CHEESE_WEDGE);
        Registry.register(Registries.ITEM, new Identifier(Cheesecraft.MOD_ID, "cheese_wheel"), CHEESE_WHEEL);

        //adds all items to groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(Items.PUMPKIN_PIE,CHEESE_WEDGE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAfter(CHEESE_WEDGE,CHEESE_WHEEL));
    }
}
