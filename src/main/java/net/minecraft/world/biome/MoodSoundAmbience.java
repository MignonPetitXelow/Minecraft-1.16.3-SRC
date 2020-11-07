package net.minecraft.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class MoodSoundAmbience
{
    public static final Codec<MoodSoundAmbience> CODEC = RecordCodecBuilder.create((moodSoundCodecInstance) ->
    {
        return moodSoundCodecInstance.group(SoundEvent.CODEC.fieldOf("sound").forGetter((moodSound) -> {
            return moodSound.sound;
        }), Codec.INT.fieldOf("tick_delay").forGetter((moodSound) -> {
            return moodSound.field_235029_d_;
        }), Codec.INT.fieldOf("block_search_extent").forGetter((moodSound) -> {
            return moodSound.field_235030_e_;
        }), Codec.DOUBLE.fieldOf("offset").forGetter((moodSound) -> {
            return moodSound.offset;
        })).apply(moodSoundCodecInstance, MoodSoundAmbience::new);
    });
    public static final MoodSoundAmbience field_235027_b_ = new MoodSoundAmbience(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0D);
    private SoundEvent sound;
    private int field_235029_d_;
    private int field_235030_e_;
    private double offset;

    public MoodSoundAmbience(SoundEvent sound, int p_i231628_2_, int p_i231628_3_, double offset)
    {
        this.sound = sound;
        this.field_235029_d_ = p_i231628_2_;
        this.field_235030_e_ = p_i231628_3_;
        this.offset = offset;
    }

    public SoundEvent getSound()
    {
        return this.sound;
    }

    public int func_235035_b_()
    {
        return this.field_235029_d_;
    }

    public int func_235037_c_()
    {
        return this.field_235030_e_;
    }

    public double getOffset()
    {
        return this.offset;
    }
}
