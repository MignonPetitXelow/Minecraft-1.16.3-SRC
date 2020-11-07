package net.minecraft.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundEvent;

public class BiomeAmbience
{
    public static final Codec<BiomeAmbience> field_235204_a_ = RecordCodecBuilder.create((p_235215_0_) ->
    {
        return p_235215_0_.group(Codec.INT.fieldOf("fog_color").forGetter((p_235229_0_) -> {
            return p_235229_0_.fogColor;
        }), Codec.INT.fieldOf("water_color").forGetter((p_235227_0_) -> {
            return p_235227_0_.waterColor;
        }), Codec.INT.fieldOf("water_fog_color").forGetter((p_235225_0_) -> {
            return p_235225_0_.waterFogColor;
        }), Codec.INT.fieldOf("sky_color").forGetter((p_242532_0_) -> {
            return p_242532_0_.field_242523_e;
        }), Codec.INT.optionalFieldOf("foliage_color").forGetter((p_244421_0_) -> {
            return p_244421_0_.field_242524_f;
        }), Codec.INT.optionalFieldOf("grass_color").forGetter((p_244422_0_) -> {
            return p_244422_0_.field_242525_g;
        }), BiomeAmbience.GrassColorModifier.field_242542_d.optionalFieldOf("grass_color_modifier", BiomeAmbience.GrassColorModifier.NONE).forGetter((p_242530_0_) -> {
            return p_242530_0_.field_242526_h;
        }), ParticleEffectAmbience.CODEC.optionalFieldOf("particle").forGetter((p_235223_0_) -> {
            return p_235223_0_.particle;
        }), SoundEvent.CODEC.optionalFieldOf("ambient_sound").forGetter((p_235221_0_) -> {
            return p_235221_0_.ambientSound;
        }), MoodSoundAmbience.CODEC.optionalFieldOf("mood_sound").forGetter((p_235219_0_) -> {
            return p_235219_0_.moodSound;
        }), SoundAdditionsAmbience.CODEC.optionalFieldOf("additions_sound").forGetter((p_235217_0_) -> {
            return p_235217_0_.additionsSound;
        }), BackgroundMusicSelector.CODEC.optionalFieldOf("music").forGetter((p_244420_0_) -> {
            return p_244420_0_.music;
        })).apply(p_235215_0_, BiomeAmbience::new);
    });
    private final int fogColor;
    private final int waterColor;
    private final int waterFogColor;
    private final int field_242523_e;
    private final Optional<Integer> field_242524_f;
    private final Optional<Integer> field_242525_g;
    private final BiomeAmbience.GrassColorModifier field_242526_h;
    private final Optional<ParticleEffectAmbience> particle;
    private final Optional<SoundEvent> ambientSound;
    private final Optional<MoodSoundAmbience> moodSound;
    private final Optional<SoundAdditionsAmbience> additionsSound;
    private final Optional<BackgroundMusicSelector> music;

    private BiomeAmbience(int p_i241938_1_, int p_i241938_2_, int p_i241938_3_, int p_i241938_4_, Optional<Integer> p_i241938_5_, Optional<Integer> p_i241938_6_, BiomeAmbience.GrassColorModifier p_i241938_7_, Optional<ParticleEffectAmbience> p_i241938_8_, Optional<SoundEvent> p_i241938_9_, Optional<MoodSoundAmbience> p_i241938_10_, Optional<SoundAdditionsAmbience> p_i241938_11_, Optional<BackgroundMusicSelector> p_i241938_12_)
    {
        this.fogColor = p_i241938_1_;
        this.waterColor = p_i241938_2_;
        this.waterFogColor = p_i241938_3_;
        this.field_242523_e = p_i241938_4_;
        this.field_242524_f = p_i241938_5_;
        this.field_242525_g = p_i241938_6_;
        this.field_242526_h = p_i241938_7_;
        this.particle = p_i241938_8_;
        this.ambientSound = p_i241938_9_;
        this.moodSound = p_i241938_10_;
        this.additionsSound = p_i241938_11_;
        this.music = p_i241938_12_;
    }

    public int getFogColor()
    {
        return this.fogColor;
    }

    public int getWaterColor()
    {
        return this.waterColor;
    }

    public int getWaterFogColor()
    {
        return this.waterFogColor;
    }

    public int func_242527_d()
    {
        return this.field_242523_e;
    }

    public Optional<Integer> func_242528_e()
    {
        return this.field_242524_f;
    }

    public Optional<Integer> func_242529_f()
    {
        return this.field_242525_g;
    }

    public BiomeAmbience.GrassColorModifier func_242531_g()
    {
        return this.field_242526_h;
    }

    public Optional<ParticleEffectAmbience> getParticle()
    {
        return this.particle;
    }

    public Optional<SoundEvent> getAmbientSound()
    {
        return this.ambientSound;
    }

    public Optional<MoodSoundAmbience> getMoodSound()
    {
        return this.moodSound;
    }

    public Optional<SoundAdditionsAmbience> getAdditionsSound()
    {
        return this.additionsSound;
    }

    public Optional<BackgroundMusicSelector> getMusic()
    {
        return this.music;
    }

    public static class Builder
    {
        private OptionalInt fogColor = OptionalInt.empty();
        private OptionalInt waterColor = OptionalInt.empty();
        private OptionalInt waterFogColor = OptionalInt.empty();
        private OptionalInt field_242533_d = OptionalInt.empty();
        private Optional<Integer> field_242534_e = Optional.empty();
        private Optional<Integer> field_242535_f = Optional.empty();
        private BiomeAmbience.GrassColorModifier field_242536_g = BiomeAmbience.GrassColorModifier.NONE;
        private Optional<ParticleEffectAmbience> particle = Optional.empty();
        private Optional<SoundEvent> ambientSound = Optional.empty();
        private Optional<MoodSoundAmbience> moodSound = Optional.empty();
        private Optional<SoundAdditionsAmbience> additionsSound = Optional.empty();
        private Optional<BackgroundMusicSelector> music = Optional.empty();

        public BiomeAmbience.Builder setFogColor(int p_235239_1_)
        {
            this.fogColor = OptionalInt.of(p_235239_1_);
            return this;
        }

        public BiomeAmbience.Builder setWaterColor(int p_235246_1_)
        {
            this.waterColor = OptionalInt.of(p_235246_1_);
            return this;
        }

        public BiomeAmbience.Builder setWaterFogColor(int p_235248_1_)
        {
            this.waterFogColor = OptionalInt.of(p_235248_1_);
            return this;
        }

        public BiomeAmbience.Builder func_242539_d(int p_242539_1_)
        {
            this.field_242533_d = OptionalInt.of(p_242539_1_);
            return this;
        }

        public BiomeAmbience.Builder func_242540_e(int p_242540_1_)
        {
            this.field_242534_e = Optional.of(p_242540_1_);
            return this;
        }

        public BiomeAmbience.Builder func_242541_f(int p_242541_1_)
        {
            this.field_242535_f = Optional.of(p_242541_1_);
            return this;
        }

        public BiomeAmbience.Builder func_242537_a(BiomeAmbience.GrassColorModifier p_242537_1_)
        {
            this.field_242536_g = p_242537_1_;
            return this;
        }

        public BiomeAmbience.Builder setParticle(ParticleEffectAmbience p_235244_1_)
        {
            this.particle = Optional.of(p_235244_1_);
            return this;
        }

        public BiomeAmbience.Builder setAmbientSound(SoundEvent p_235241_1_)
        {
            this.ambientSound = Optional.of(p_235241_1_);
            return this;
        }

        public BiomeAmbience.Builder setMoodSound(MoodSoundAmbience p_235243_1_)
        {
            this.moodSound = Optional.of(p_235243_1_);
            return this;
        }

        public BiomeAmbience.Builder setAdditionsSound(SoundAdditionsAmbience p_235242_1_)
        {
            this.additionsSound = Optional.of(p_235242_1_);
            return this;
        }

        public BiomeAmbience.Builder setMusic(BackgroundMusicSelector p_235240_1_)
        {
            this.music = Optional.of(p_235240_1_);
            return this;
        }

        public BiomeAmbience build()
        {
            return new BiomeAmbience(this.fogColor.orElseThrow(() ->
            {
                return new IllegalStateException("Missing 'fog' color.");
            }), this.waterColor.orElseThrow(() ->
            {
                return new IllegalStateException("Missing 'water' color.");
            }), this.waterFogColor.orElseThrow(() ->
            {
                return new IllegalStateException("Missing 'water fog' color.");
            }), this.field_242533_d.orElseThrow(() ->
            {
                return new IllegalStateException("Missing 'sky' color.");
            }), this.field_242534_e, this.field_242535_f, this.field_242536_g, this.particle, this.ambientSound, this.moodSound, this.additionsSound, this.music);
        }
    }

    public static enum GrassColorModifier implements IStringSerializable
    {
        NONE("none")
        {
            public int func_241853_a(double p_241853_1_, double p_241853_3_, int p_241853_5_)
            {
                return p_241853_5_;
            }
        },
        DARK_FOREST("dark_forest")
        {
            public int func_241853_a(double p_241853_1_, double p_241853_3_, int p_241853_5_)
            {
                return (p_241853_5_ & 16711422) + 2634762 >> 1;
            }
        },
        SWAMP("swamp")
        {
            public int func_241853_a(double p_241853_1_, double p_241853_3_, int p_241853_5_)
            {
                double d0 = Biome.INFO_NOISE.noiseAt(p_241853_1_ * 0.0225D, p_241853_3_ * 0.0225D, false);
                return d0 < -0.1D ? 5011004 : 6975545;
            }
        };

        private final String field_242543_e;
        public static final Codec<BiomeAmbience.GrassColorModifier> field_242542_d = IStringSerializable.createEnumCodec(BiomeAmbience.GrassColorModifier::values, BiomeAmbience.GrassColorModifier::func_242546_a);
        private static final Map<String, BiomeAmbience.GrassColorModifier> field_242544_f = Arrays.stream(values()).collect(Collectors.toMap(BiomeAmbience.GrassColorModifier::func_242547_b, (p_242545_0_) -> {
            return p_242545_0_;
        }));

        public abstract int func_241853_a(double p_241853_1_, double p_241853_3_, int p_241853_5_);

        private GrassColorModifier(String p_i241940_3_)
        {
            this.field_242543_e = p_i241940_3_;
        }

        public String func_242547_b()
        {
            return this.field_242543_e;
        }

        public String getString()
        {
            return this.field_242543_e;
        }

        public static BiomeAmbience.GrassColorModifier func_242546_a(String p_242546_0_)
        {
            return field_242544_f.get(p_242546_0_);
        }
    }
}
