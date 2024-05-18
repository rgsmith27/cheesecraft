package irish.modid;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //all blocks
    public static final Block AGED_CHEESE_WHEEL = new Block(ModBlockSettings.AGED_CHEESE_WHEEL);
    public static final Block CHEESE_WHEEL = new Block(ModBlockSettings.CHEESE_WHEEL);
    public static final Block FRESH_CHEESE_WHEEL = new Block(ModBlockSettings.FRESH_CHEESE_WHEEL);
    public static final Block SALT_BLOCK = new Block(ModBlockSettings.SALT_BLOCK);


    public static void initialize(){
        //registers all blocks
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "aged_cheese_wheel"), AGED_CHEESE_WHEEL);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "cheese_wheel"), CHEESE_WHEEL);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "fresh_cheese_wheel"), FRESH_CHEESE_WHEEL);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "salt_block"), SALT_BLOCK);
    }
}
