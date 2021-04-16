package me.earth.headlessforge.mixin.gui;

import me.earth.headlessforge.inject.ducks.IGuiMessage;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiDisconnected.class)
public abstract class MixinGuiDisconnected implements IGuiMessage {
    @Shadow
    @Final
    private String reason;

    @Shadow
    @Final
    private ITextComponent message;

    @Override
    public String getMessage()
    {
        return reason + " : " + GuiUtilRenderComponents.removeTextColorsIfConfigured(message.getUnformattedText(), false);
    }

}