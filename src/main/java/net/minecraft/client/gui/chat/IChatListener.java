package net.minecraft.client.gui.chat;

import java.util.UUID;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;

public interface IChatListener
{
    void say(ChatType chatTypeIn, ITextComponent message, UUID sender);
}
