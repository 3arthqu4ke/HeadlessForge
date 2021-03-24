package me.earth.headlessforge.mixin.renderer;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.renderer.RenderGlobal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderGlobal.class)
public abstract class MixinRenderGlobal {
    @Inject(method = "drawBoundingBox(DDDDDDFFFF)V", at = @At("HEAD"), cancellable = true)
    private static void drawBoundingBoxHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "drawBoundingBox(Lnet/minecraft/client/renderer/BufferBuilder;DDDDDDFFFF)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void drawBoundingBoxHook1(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "renderFilledBox(Lnet/minecraft/util/math/AxisAlignedBB;FFFF)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void renderFilledBoxHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "renderFilledBox(DDDDDDFFFF)V", at = @At("HEAD"), cancellable = true)
    private static void renderFilledBoxHook1(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "addChainedFilledBoxVertices", at = @At("HEAD"), cancellable = true)
    private static void addChainedFilledBoxVerticesHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}