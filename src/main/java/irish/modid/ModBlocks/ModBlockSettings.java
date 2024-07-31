package irish.modid.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlockSettings {
    //all block settings
    public static final Block.Settings AGED_CHEESE_WHEEL_BLOCK = Block.Settings.create().breakInstantly();
    public static final Block.Settings CHEESE_WHEEL_BLOCK = Block.Settings.create().breakInstantly();
    public static final Block.Settings FRESH_CHEESE_WHEEL_BLOCK = Block.Settings.create().breakInstantly();
    public static final Block.Settings SALT_BLOCK_BLOCK = Block.Settings.create().hardness(1.5f).resistance(6.0f).requiresTool();
    public static final Block.Settings CASK_BLOCK_BLOCK = Block.Settings.create().hardness(2.0f).resistance(3.0f).sounds(BlockSoundGroup.WOOD);
}
