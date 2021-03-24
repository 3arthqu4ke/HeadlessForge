package me.earth.headlessforge.mixin.util;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.util.MouseHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHelper.class)
public abstract class MixinMouseHelper {
    @Inject(method = "grabMouseCursor", at = @At("HEAD"), cancellable = true)
    private void grabMouseCursorHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "ungrabMouseCursor", at = @At("HEAD"), cancellable = true)
    private void ungrabMouseCursorHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}
