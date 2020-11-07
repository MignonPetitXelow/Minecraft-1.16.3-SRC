package net.minecraft.client.gui;

import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.WithNarratorSettingsScreen;
import net.minecraft.util.text.TranslationTextComponent;

public class AccessibilityScreen extends WithNarratorSettingsScreen
{
    private static final AbstractOption[] OPTIONS = new AbstractOption[] {AbstractOption.NARRATOR, AbstractOption.SHOW_SUBTITLES, AbstractOption.ACCESSIBILITY_TEXT_BACKGROUND_OPACITY, AbstractOption.ACCESSIBILITY_TEXT_BACKGROUND, AbstractOption.CHAT_OPACITY, AbstractOption.field_238235_g_, AbstractOption.field_238236_h_, AbstractOption.AUTO_JUMP, AbstractOption.SNEAK, AbstractOption.SPRINT, AbstractOption.field_243219_k, AbstractOption.field_243218_j};

    public AccessibilityScreen(Screen parentScreen, GameSettings settings)
    {
        super(parentScreen, settings, new TranslationTextComponent("options.accessibility.title"), OPTIONS);
    }
}
