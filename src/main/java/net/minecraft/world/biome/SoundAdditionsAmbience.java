package net.minecraft.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.SoundEvent;

public class SoundAdditionsAmbience
{
    public static final Codec<SoundAdditionsAmbience> CODEC = RecordCodecBuilder.create((soundAdditionsCodecInstance) ->
    {
        return soundAdditionsCodecInstance.group(SoundEvent.CODEC.fieldOf("sound").forGetter((soundAdditions) -> {
            return soundAdditions.field_235019_b_;
        }), Codec.DOUBLE.fieldOf("tick_chance").forGetter((soundAdditions) -> {
            return soundAdditions.field_235020_c_;
        })).apply(soundAdditionsCodecInstance, SoundAdditionsAmbience::new);
    });
    private SoundEvent field_235019_b_;
    private double field_235020_c_;

    public SoundAdditionsAmbience(SoundEvent sound, double p_i231627_2_)
    {
        this.field_235019_b_ = sound;
        this.field_235020_c_ = p_i231627_2_;
    }

    public SoundEvent getSound()
    {
        return this.field_235019_b_;
    }

    public double func_235024_b_()
    {
        return this.field_235020_c_;
    }
}
