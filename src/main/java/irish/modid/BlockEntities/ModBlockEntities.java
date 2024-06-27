package irish.modid.BlockEntities;

import irish.modid.Cheesecraft;
import irish.modid.ModBlocks.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    //declares tile entities
    public static final BlockEntityType<CaskBlockEntity> CASK_BLOCK_ENTITY = BlockEntityType.Builder.create(CaskBlockEntity::new, ModBlocks.CASK_BLOCK).build();

    //registers tile entities
    public static void initialize(){
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Cheesecraft.MOD_ID, "cask_block_entity"), CASK_BLOCK_ENTITY);
    }

}
