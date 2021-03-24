package me.earth.headlessforge.mixin.forge;

import me.earth.headlessforge.inject.Hooks;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.SplashProgress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FMLClientHandler.class, remap = false)
public abstract class MixinFMLClientHandler {
    @Redirect(
        method = "beginMinecraftLoading",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraftforge/fml/client/SplashProgress;start()V")
    )
    private void beginMinecraftLoadingHook() {
        Hooks.RUN_HOOK.invoke(SplashProgress::start);
    }

    @Inject(
        method = "processWindowMessages",
        at = @At("HEAD"),
        cancellable = true)
    private void processWindowMessagesHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "updateCloudSettings",
        at = @At("HEAD"),
        cancellable = true)
    private void cloudHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "isDisplayCloseRequested",
        at = @At("HEAD"),
        cancellable = true)
    private void isDisplayCloseRequestedHook(CallbackInfoReturnable<Boolean> cir) {
        Hooks.returnableHook(cir, false);
    }
}