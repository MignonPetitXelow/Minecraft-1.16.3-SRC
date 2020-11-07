package net.minecraft.resources;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public interface IPackNameDecorator
{
    IPackNameDecorator field_232625_a_ = func_232629_a_();
    IPackNameDecorator BUILTIN = create("pack.source.builtin");
    IPackNameDecorator WORLD = create("pack.source.world");
    IPackNameDecorator SERVER = create("pack.source.server");

    ITextComponent decorate(ITextComponent p_decorate_1_);

    static IPackNameDecorator func_232629_a_()
    {
        return (name) ->
        {
            return name;
        };
    }

    static IPackNameDecorator create(String source)
    {
        ITextComponent itextcomponent = new TranslationTextComponent(source);
        return (name) ->
        {
            return new TranslationTextComponent("pack.nameAndSource", name, itextcomponent);
        };
    }
}
