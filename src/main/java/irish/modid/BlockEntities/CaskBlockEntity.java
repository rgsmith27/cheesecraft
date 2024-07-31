package irish.modid.BlockEntities;

import irish.modid.ImplementedInventory;
import irish.modid.ModBlocks.CaskBlock;
import irish.modid.ModItems.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;

public class CaskBlockEntity extends BlockEntity implements ImplementedInventory {
    //keeps track of the contents of the cask
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    //number of ticks in a day
    private static final int DAY_LENGTH = 24000;

    //stores the age of cheese in the cask
    public int ageTicks = 0;

    public CaskBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.CASK_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    //nbt read/write to store inventory information and age time
    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.readNbt(nbt, wrapper);
        this.ageTicks = nbt.getInt("AgeTicks");
        Inventories.readNbt(nbt, items, wrapper);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper){
        Inventories.writeNbt(nbt, items, wrapper);
        nbt.putInt("AgeTicks",this.ageTicks);
        super.writeNbt(nbt, wrapper);
    }

    //allows reset of the ageTicks variable
    public void resetAge(){
        this.ageTicks = 0;
    }

    //returns a hashmap with items that can be aged as keys and the time they need to fully age as values
    public static HashMap<Item, Integer> getAgeables(){
        HashMap<Item, Integer> ageTimes = new HashMap<>();
        ageTimes.put(ModItems.FRESH_CHEESE_WHEEL, DAY_LENGTH);
        ageTimes.put(ModItems.CHEESE_WHEEL, DAY_LENGTH * 7);
        return ageTimes;
    }

    //handles gameticks
    public static void tick(World world, BlockPos blockPos, BlockState blockState, CaskBlockEntity blockEntity){
        if(blockEntity.containsAny(CaskBlockEntity.getAgeables().keySet())){
            //adds to ageTicks if there are any ageables in the cask
            blockEntity.ageTicks++;
            //updates blockState and resets ageTicks if the item inside the cask is fully aged
            if(blockEntity.getStack(0).isOf(ModItems.FRESH_CHEESE_WHEEL) && blockEntity.ageTicks > getAgeables().get(ModItems.FRESH_CHEESE_WHEEL)){
                blockEntity.setStack(0,new ItemStack(ModItems.CHEESE_WHEEL));
                world.setBlockState(blockPos, blockState.with(CaskBlock.CONTENTS, 2));
                blockEntity.resetAge();
            }
            else if(blockEntity.getStack(0).isOf(ModItems.CHEESE_WHEEL) && blockEntity.ageTicks > getAgeables().get(ModItems.CHEESE_WHEEL)){
                blockEntity.setStack(0, new ItemStack(ModItems.AGED_CHEESE_WHEEL));
                world.setBlockState(blockPos, blockState.with(CaskBlock.CONTENTS, 3));
                blockEntity.resetAge();
            }
            //resets ageTicks if the cask is empty
        } else{
            blockEntity.resetAge();
        }
        markDirty(world, blockPos, blockState);
    }
}