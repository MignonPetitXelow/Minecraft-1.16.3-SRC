package net.minecraft.client.gui;

public class ChatLine<T>
{
    private final int updateCounterCreated;
    private final T lineString;
    private final int chatLineID;

    public ChatLine(int p_i242050_1_, T p_i242050_2_, int p_i242050_3_)
    {
        this.lineString = p_i242050_2_;
        this.updateCounterCreated = p_i242050_1_;
        this.chatLineID = p_i242050_3_;
    }

    public T getLineString()
    {
        return this.lineString;
    }

    public int getUpdatedCounter()
    {
        return this.updateCounterCreated;
    }

    public int getChatLineID()
    {
        return this.chatLineID;
    }
}
