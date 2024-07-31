package irish.modid.ModBlocks;

import irish.modid.Cheesecraft;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //all blocks
    public static final Block AGED_CHEESE_WHEEL_BLOCK = new CheeseWheelBlock(ModBlockSettings.AGED_CHEESE_WHEEL_BLOCK);
    public static final Block CHEESE_WHEEL_BLOCK = new CheeseWheelBlock(ModBlockSettings.CHEESE_WHEEL_BLOCK);
    public static final Block FRESH_CHEESE_WHEEL_BLOCK = new CheeseWheelBlock(ModBlockSettings.FRESH_CHEESE_WHEEL_BLOCK);
    public static final Block SALT_BLOCK_BLOCK = new Block(ModBlockSettings.SALT_BLOCK_BLOCK);
    public static final Block CASK_BLOCK = new CaskBlock(ModBlockSettings.CASK_BLOCK_BLOCK);

    public static void initialize(){
        //registers all blocks
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "aged_cheese_wheel"), AGED_CHEESE_WHEEL_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "cheese_wheel"), CHEESE_WHEEL_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "fresh_cheese_wheel"), FRESH_CHEESE_WHEEL_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "salt_block"), SALT_BLOCK_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "cask"), CASK_BLOCK);
    }
}
