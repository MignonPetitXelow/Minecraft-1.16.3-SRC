package net.minecraft.tags;

import java.util.List;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;

public final class FluidTags
{
    protected static final TagRegistry<Fluid> collection = TagRegistryManager.func_242196_a(new ResourceLocation("fluid"), ITagCollectionSupplier::func_241837_c);
    public static final ITag.INamedTag<Fluid> WATER = makeWrapperTag("water");
    public static final ITag.INamedTag<Fluid> LAVA = makeWrapperTag("lava");

    private static ITag.INamedTag<Fluid> makeWrapperTag(String id)
    {
        return collection.func_232937_a_(id);
    }

    public static List <? extends ITag.INamedTag<Fluid >> func_241280_c_()
    {
        return collection.func_241288_c_();
    }
}
