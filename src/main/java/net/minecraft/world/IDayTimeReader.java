package net.minecraft.world;

public interface IDayTimeReader extends IWorldReader
{
    long func_241851_ab();

default float func_242413_ae()
    {
        return DimensionType.MOON_PHASE_FACTORS[this.func_230315_m_().func_236035_c_(this.func_241851_ab())];
    }

default float func_242415_f(float p_242415_1_)
    {
        return this.func_230315_m_().func_236032_b_(this.func_241851_ab());
    }

default int func_242414_af()
    {
        return this.func_230315_m_().func_236035_c_(this.func_241851_ab());
    }
}
