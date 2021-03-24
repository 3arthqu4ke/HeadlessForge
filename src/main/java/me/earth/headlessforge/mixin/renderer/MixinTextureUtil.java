package me.earth.headlessforge.mixin.renderer;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.image.BufferedImage;

@Mixin(TextureUtil.class)
abstract class MixinTextureUtil {
    @Inject(method = "glGenTextures", at = @At("HEAD"), cancellable = true)
    private static void glGenTexturesHook(CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "deleteTexture", at = @At("HEAD"), cancellable = true)
    private static void deleteTextureHook(int textureId, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "uploadTextureImage", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureImageHook(int textureId,
                                               BufferedImage texture,
                                               CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "uploadTexture", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureHook(int textureId,
                                          int[] p_110988_1_,
                                          int p_110988_2_,
                                          int p_110988_3_,
                                          CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "blendColors", at = @At("HEAD"), cancellable = true)
    private static void blendColorsHook(int p_147943_0_,
                                        int p_147943_1_,
                                        int p_147943_2_,
                                        int p_147943_3_,
                                        boolean p_147943_4_,
                                        CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "blendColorComponent", at = @At("HEAD"), cancellable = true)
    private static void blendColorComponentHook(int p_147944_0_,
                                                int p_147944_1_,
                                                int p_147944_2_,
                                                int p_147944_3_,
                                                int p_147944_4_,
                                                CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "uploadTextureMipmap", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureMipmapHook(int[][] p_147955_0_,
                                                int p_147955_1_,
                                                int p_147955_2_,
                                                int p_147955_3_,
                                                int p_147955_4_,
                                                boolean p_147955_5_,
                                                boolean p_147955_6_,
                                                CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "uploadTextureSub", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureSubHook(int p_147947_0_,
                                             int[] p_147947_1_,
                                             int p_147947_2_,
                                             int p_147947_3_,
                                             int p_147947_4_,
                                             int p_147947_5_,
                                             boolean p_147947_6_,
                                             boolean p_147947_7_,
                                             boolean p_147947_8_,
                                             CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "uploadTextureImageAllocate", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureImageAllocateHook(int textureId,
                                                       BufferedImage texture,
                                                       boolean blur,
                                                       boolean clamp,
                                                       CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, textureId);
    }

    @Inject(method = "allocateTextureImpl", at = @At("HEAD"), cancellable = true)
    private static void allocateTextureImplHook(int glTextureId,
                                                int mipmapLevels,
                                                int width,
                                                int height,
                                                CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "uploadTextureImageSub", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureImageSubHook(int textureId,
                                                  BufferedImage p_110995_1_,
                                                  int p_110995_2_,
                                                  int p_110995_3_,
                                                  boolean p_110995_4_,
                                                  boolean p_110995_5_,
                                                  CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, textureId);
    }

    @Inject(method = "uploadTextureImageSubImpl", at = @At("HEAD"), cancellable = true)
    private static void uploadTextureImageSubImplHook(BufferedImage p_110993_0_,
                                                      int p_110993_1_,
                                                      int p_110993_2_,
                                                      boolean p_110993_3_,
                                                      boolean p_110993_4_,
                                                      CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setTextureClamped", at = @At("HEAD"), cancellable = true)
    private static void setTextureClampedHook(boolean p_110997_0_, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setTextureBlurMipmap", at = @At("HEAD"), cancellable = true)
    private static void setTextureBlurMipmapHook(boolean p_147954_0_,
                                                 boolean p_147954_1_,
                                                 CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "copyToBufferPos", at = @At("HEAD"), cancellable = true)
    private static void copyToBufferPosHook(int[] p_110994_0_,
                                            int p_110994_1_,
                                            int p_110994_2_,
                                            CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "bindTexture", at = @At("HEAD"), cancellable = true)
    private static void bindTextureHook(int p_94277_0_, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "processPixelValues", at = @At("HEAD"), cancellable = true)
    private static void processPixelValuesHook(int[] p_147953_0_,
                                               int p_147953_1_,
                                               int p_147953_2_,
                                               CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}