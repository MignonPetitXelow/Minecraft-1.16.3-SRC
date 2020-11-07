package net.minecraft.util;

import com.mojang.serialization.Codec;

public class SoundEvent
{
    public static final Codec<SoundEvent> CODEC = ResourceLocation.CODEC.xmap(SoundEvent::new, (p_232679_0_) ->
    {
        return p_232679_0_.name;
    });
    private final ResourceLocation name;

    public SoundEvent(ResourceLocation name)
    {
        this.name = name;
    }

    public ResourceLocation getName()
    {
        return this.name;
    }
}
