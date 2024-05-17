package irish.modid;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //all blocks
    public static final Block CHEESE_WHEEL = new Block(ModBlockSettings.CHEESE_WHEEL);

    public static void initialize(){
        //registers all blocks
        Registry.register(Registries.BLOCK, new Identifier(Cheesecraft.MOD_ID, "cheese_wheel"), CHEESE_WHEEL);
    }
}
