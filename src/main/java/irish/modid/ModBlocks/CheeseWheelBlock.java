package irish.modid.ModBlocks;

import net.minecraft.block.*;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

public class CheeseWheelBlock extends Block {

    //defines the shape of the cheese wheels (same as cake)
    public static final VoxelShape WHEEL_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);

    public CheeseWheelBlock(Settings settings){
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return WHEEL_SHAPE;
    }
}

