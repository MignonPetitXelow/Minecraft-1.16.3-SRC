package net.minecraft.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BarrierBlock extends Block
{
    protected BarrierBlock(AbstractBlock.Properties properties)
    {
        super(properties);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos)
    {
        return true;
    }

    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.INVISIBLE;
    }

    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 1.0F;
    }
}
