package net.minecraft.block.trees;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;

public class OakTree extends Tree
{
    @Nullable
    protected ConfiguredFeature < BaseTreeFeatureConfig, ? > getTreeFeature(Random randomIn, boolean largeHive)
    {
        if (randomIn.nextInt(10) == 0)
        {
            return largeHive ? Features.field_243922_ce : Features.field_243869_bO;
        }
        else
        {
            return largeHive ? Features.field_243879_bY : Features.field_243862_bH;
        }
    }
}
