package me.earth.headlessforge.mixin.gui;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FontRenderer.class)
public abstract class MixinFontRenderer {
    @Inject(method = "readGlyphSizes", at = @At("HEAD"), cancellable = true)
    private void readGlyphSizesHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}