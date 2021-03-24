package me.earth.headlessforge.mixin.renderer;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.renderer.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextureManager.class)
public abstract class MixinTextureManager
{
    @Inject(method = "bindTexture", at = @At("HEAD"), cancellable = true)
    private void bindTextureHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}