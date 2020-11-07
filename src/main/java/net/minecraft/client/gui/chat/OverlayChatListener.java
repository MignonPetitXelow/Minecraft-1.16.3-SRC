package net.minecraft.client.gui.chat;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;

public class OverlayChatListener implements IChatListener
{
    private final Minecraft mc;

    public OverlayChatListener(Minecraft minecraftIn)
    {
        this.mc = minecraftIn;
    }

    public void say(ChatType chatTypeIn, ITextComponent message, UUID sender)
    {
        if (!this.mc.func_238198_a_(sender))
        {
            this.mc.ingameGUI.setOverlayMessage(message, false);
        }
    }
}
