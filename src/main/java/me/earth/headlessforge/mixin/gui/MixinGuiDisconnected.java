package me.earth.headlessforge.mixin.gui;

import me.earth.headlessforge.inject.ducks.IGuiMessage;
import net.minecraft.client.gui.GuiDisconnected;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GuiDisconnected.class)
public abstract class MixinGuiDisconnected implements IGuiMessage {
    @Override
    @Accessor("reason")
    public abstract String getMessage();

}