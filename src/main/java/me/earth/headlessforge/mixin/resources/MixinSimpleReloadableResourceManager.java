package me.earth.headlessforge.mixin.resources;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SimpleReloadableResourceManager.class)
public abstract class MixinSimpleReloadableResourceManager {
    @Inject(method = "registerReloadListener", at = @At("HEAD"), cancellable = true)
    private void registerReloadListenerHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "reloadResources", at = @At("HEAD"), cancellable = true)
    private void reloadResourcesHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "notifyReloadListeners", at = @At("HEAD"), cancellable = true)
    private void notifyReloadListenersHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}