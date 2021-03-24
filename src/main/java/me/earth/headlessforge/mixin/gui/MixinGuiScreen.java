package me.earth.headlessforge.mixin.gui;

import me.earth.headlessforge.inject.ducks.IGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.io.IOException;
import java.util.List;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen implements IGuiScreen
{
    @Override
    @Accessor("buttonList")
    public abstract List<GuiButton> getButtons();

    @Override
    @Invoker("keyTyped")
    public abstract void invokeKeyTyped(char typedChar, int keyCode);

    @Override
    @Invoker("mouseClicked")
    public abstract void invokeMouseClick(int mouseX, int mouseY, int mouseButton) throws IOException;
}
