package net.minecraft.client.gui;

import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DialogTexts
{
    public static final ITextComponent OPTIONS_ON = new TranslationTextComponent("options.on");
    public static final ITextComponent OPTIONS_OFF = new TranslationTextComponent("options.off");
    public static final ITextComponent GUI_DONE = new TranslationTextComponent("gui.done");
    public static final ITextComponent GUI_CANCEL = new TranslationTextComponent("gui.cancel");
    public static final ITextComponent GUI_YES = new TranslationTextComponent("gui.yes");
    public static final ITextComponent GUI_NO = new TranslationTextComponent("gui.no");
    public static final ITextComponent GUI_PROCEED = new TranslationTextComponent("gui.proceed");
    public static final ITextComponent GUI_BACK = new TranslationTextComponent("gui.back");
    public static final ITextComponent field_244280_i = new TranslationTextComponent("connect.failed");

    public static ITextComponent func_240638_a_(boolean p_240638_0_)
    {
        return p_240638_0_ ? OPTIONS_ON : OPTIONS_OFF;
    }

    public static IFormattableTextComponent func_244281_a(ITextComponent p_244281_0_, boolean p_244281_1_)
    {
        return new TranslationTextComponent(p_244281_1_ ? "options.on.composed" : "options.off.composed", p_244281_0_);
    }
}
