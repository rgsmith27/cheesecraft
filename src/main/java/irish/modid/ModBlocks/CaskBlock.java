package irish.modid.ModBlocks;

import com.mojang.serialization.MapCodec;
import irish.modid.BlockEntities.CaskBlockEntity;
import irish.modid.BlockEntities.ModBlockEntities;
import irish.modid.ModItems.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CaskBlock extends BlockWithEntity {
    public static final IntProperty CONTENTS = IntProperty.of("contents", 0,3);

    //constructor sets default state as an empty cask
    public CaskBlock(Settings settings){
        super(settings);
        setDefaultState(getDefaultState().with(CONTENTS, 0));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(CONTENTS);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new CaskBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state){
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return validateTicker(type, ModBlockEntities.CASK_BLOCK_ENTITY, (world1, pos, state1, be) -> CaskBlockEntity.tick(world1, pos, state1, be));
    }

    //on use handles adding/removing items from inventory
    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient)
            return ActionResult.SUCCESS;

        Inventory blockEntityInventory = (Inventory) world.getBlockEntity(blockPos);
        BlockEntity blockEntity = world.getBlockEntity(blockPos);

        //if the cask is empty
        if(blockEntityInventory.getStack(0).isEmpty()){
            //if main hand contains fresh or reg cheese
            if(player.getMainHandStack().isOf(ModItems.FRESH_CHEESE_WHEEL)){
                blockEntityInventory.setStack(0,player.getMainHandStack().copy());
                player.getMainHandStack().setCount(0);
                world.setBlockState(blockPos, blockState.with(CONTENTS,1));
            }
            else if(player.getMainHandStack().isOf(ModItems.CHEESE_WHEEL)){
                blockEntityInventory.setStack(0,player.getMainHandStack().copy());
                player.getMainHandStack().setCount(0);
                world.setBlockState(blockPos, blockState.with(CONTENTS,2));
            }
            //if offhand contains fresh or reg cheese
            else if(player.getOffHandStack().isOf(ModItems.FRESH_CHEESE_WHEEL)){
                blockEntityInventory.setStack(0,player.getOffHandStack().copy());
                player.getOffHandStack().setCount(0);
                world.setBlockState(blockPos, blockState.with(CONTENTS,1));
            }
            else if(player.getOffHandStack().isOf(ModItems.CHEESE_WHEEL)){
                blockEntityInventory.setStack(0,player.getOffHandStack().copy());
                player.getOffHandStack().setCount(0);
                world.setBlockState(blockPos, blockState.with(CONTENTS,2));
            }
        }
        //otherwise removes item from cask and adds to player inventory
        else{
            player.getInventory().offerOrDrop(blockEntityInventory.getStack(0));
            blockEntityInventory.removeStack(0);
            world.setBlockState(blockPos, blockState.with(CONTENTS, 0));
        }
        //resets the age after the cask is interacted with to prevent possible carryover
        if(blockEntity instanceof CaskBlockEntity){
            ((CaskBlockEntity) blockEntity).resetAge();
        }
        return ActionResult.SUCCESS;
    }

    @Override
    //drops the inventory contents of the cask on break
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player){
        BlockEntity blockEntity = world.getBlockEntity(pos);
        Inventory blockEntityInventory = (Inventory) world.getBlockEntity(pos);
        if(blockEntity != null && !world.isClient && !blockEntityInventory.getStack(0).isEmpty()){
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), blockEntityInventory.getStack(0));
        }
        return super.onBreak(world, pos, state, player);
    }

}
