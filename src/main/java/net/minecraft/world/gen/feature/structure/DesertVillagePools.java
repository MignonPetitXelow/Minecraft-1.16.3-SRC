package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;

public class DesertVillagePools
{
    public static final JigsawPattern field_243774_a = JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/town_centers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/town_centers/desert_meeting_point_1"), 98), Pair.of(JigsawPiece.func_242849_a("village/desert/town_centers/desert_meeting_point_2"), 98), Pair.of(JigsawPiece.func_242849_a("village/desert/town_centers/desert_meeting_point_3"), 49), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/town_centers/desert_meeting_point_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/town_centers/desert_meeting_point_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/town_centers/desert_meeting_point_3", ProcessorLists.field_244106_f), 1)), JigsawPattern.PlacementBehaviour.RIGID));

    public static void init()
    {
    }

    static
    {
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/streets"), new ResourceLocation("village/desert/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/streets/corner_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/corner_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/straight_01"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/straight_02"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/straight_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/crossroad_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/crossroad_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/crossroad_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/square_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/square_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/streets"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_01"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_02"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/houses"), new ResourceLocation("village/desert/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_2"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_3"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_4"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_5"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_6"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_7"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_small_house_8"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_medium_house_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_medium_house_2"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_butcher_shop_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_tool_smith_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_fletcher_house_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_shepherd_house_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_armorer_1"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_fisher_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_tannery_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_cartographer_house_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_library_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_mason_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_weaponsmith_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_temple_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_temple_2"), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_large_farm_1", ProcessorLists.field_244117_q), 11), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_1", ProcessorLists.field_244117_q), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_2", ProcessorLists.field_244117_q), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_animal_pen_1"), 2), Pair.of(JigsawPiece.func_242849_a("village/desert/houses/desert_animal_pen_2"), 2), Pair.of(JigsawPiece.func_242864_g(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/houses"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_3", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_4", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_5", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_6", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_7", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_8", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_butcher_shop_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tool_smith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fletcher_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_shepherd_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_armorer_1", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fisher_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tannery_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_cartographer_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_library_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_mason_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_weaponsmith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_large_farm_1", ProcessorLists.field_244106_f), 7), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_1", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_2", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242864_g(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/terminators/terminator_01"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/terminators/terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/terminators/terminator_01"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/terminators/terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/desert_lamp_1"), 10), Pair.of(JigsawPiece.func_242845_a(Features.field_243814_aM), 4), Pair.of(JigsawPiece.func_242845_a(Features.field_243834_ag), 4), Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/desert_lamp_1", ProcessorLists.field_244106_f), 10), Pair.of(JigsawPiece.func_242845_a(Features.field_243814_aM), 4), Pair.of(JigsawPiece.func_242845_a(Features.field_243834_ag), 4), Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/villagers/nitwit"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/villagers/baby"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/nitwit"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
    }
}