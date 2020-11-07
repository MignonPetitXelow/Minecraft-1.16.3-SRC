package net.minecraft.world;

import java.util.Optional;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;

public class EntityExplosionContext extends ExplosionContext
{
    private final Entity field_234889_a_;

    public EntityExplosionContext(Entity p_i231609_1_)
    {
        this.field_234889_a_ = p_i231609_1_;
    }

    public Optional<Float> getExplosionResistance(Explosion explosion, IBlockReader reader, BlockPos pos, BlockState state, FluidState fluid)
    {
        return super.getExplosionResistance(explosion, reader, pos, state, fluid).map((p_234890_6_) ->
        {
            return this.field_234889_a_.getExplosionResistance(explosion, reader, pos, state, fluid, p_234890_6_);
        });
    }

    public boolean canExplosionDestroyBlock(Explosion explosion, IBlockReader reader, BlockPos pos, BlockState state, float power)
    {
        return this.field_234889_a_.canExplosionDestroyBlock(explosion, reader, pos, state, power);
    }
}
