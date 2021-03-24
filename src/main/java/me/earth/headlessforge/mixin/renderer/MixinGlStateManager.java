package me.earth.headlessforge.mixin.renderer;

import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.util.vector.Quaternion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Mixin(GlStateManager.class)
public abstract class MixinGlStateManager {
    @Inject(method = "pushAttrib", at = @At("HEAD"), cancellable = true)
    private static void pushAttribHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "popAttrib", at = @At("HEAD"), cancellable = true)
    private static void popAttribHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableAlpha", at = @At("HEAD"), cancellable = true)
    private static void disableAlphaHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableAlpha", at = @At("HEAD"), cancellable = true)
    private static void enableAlphaHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "alphaFunc", at = @At("HEAD"), cancellable = true)
    private static void alphaFuncHook(int func, float ref, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableLighting", at = @At("HEAD"), cancellable = true)
    private static void enableLighting(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableLighting", at = @At("HEAD"), cancellable = true)
    private static void disableLighting(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableLight", at = @At("HEAD"), cancellable = true)
    private static void enableLight(int light, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableLight", at = @At("HEAD"), cancellable = true)
    private static void disableLight(int light, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableColorMaterial", at = @At("HEAD"), cancellable = true)
    private static void enableColorMaterial(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableColorMaterial", at = @At("HEAD"), cancellable = true)
    private static void disableColorMaterial(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "colorMaterial", at = @At("HEAD"), cancellable = true)
    private static void colorMaterial(int face, int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glLight", at = @At("HEAD"), cancellable = true)
    private static void glLight(int light, int pname, FloatBuffer params, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glLightModel", at = @At("HEAD"), cancellable = true)
    private static void glLightModel(int pname, FloatBuffer params, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glNormal3f", at = @At("HEAD"), cancellable = true)
    private static void glNormal3f(float nx, float ny, float nz, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableDepth", at = @At("HEAD"), cancellable = true)
    private static void disableDepth(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableDepth", at = @At("HEAD"), cancellable = true)
    private static void enableDepth(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "depthFunc", at = @At("HEAD"), cancellable = true)
    private static void depthFunc(int depthFunc, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "depthMask", at = @At("HEAD"), cancellable = true)
    private static void depthMask(boolean flagIn, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableBlend", at = @At("HEAD"), cancellable = true)
    private static void disableBlend(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableBlend", at = @At("HEAD"), cancellable = true)
    private static void enableBlend(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "blendFunc(Lnet/minecraft/client/renderer/GlStateManager$SourceFactor;Lnet/minecraft/client/renderer/GlStateManager$DestFactor;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void blendFunc(GlStateManager.SourceFactor srcFactor,
                                  GlStateManager.DestFactor dstFactor,
                                  CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "blendFunc(II)V", at = @At("HEAD"), cancellable = true)
    private static void blendFunc(int srcFactor, int dstFactor, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "tryBlendFuncSeparate(Lnet/minecraft/client/renderer/GlStateManager$SourceFactor;Lnet/minecraft/client/renderer/GlStateManager$DestFactor;Lnet/minecraft/client/renderer/GlStateManager$SourceFactor;Lnet/minecraft/client/renderer/GlStateManager$DestFactor;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void tryBlendFuncSeparate(
            GlStateManager.SourceFactor srcFactor,
            GlStateManager.DestFactor dstFactor,
            GlStateManager.SourceFactor srcFactorAlpha,
            GlStateManager.DestFactor dstFactorAlpha,
            CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "tryBlendFuncSeparate(IIII)V", at = @At("HEAD"), cancellable = true)
    private static void tryBlendFuncSeparate(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glBlendEquation", at = @At("HEAD"), cancellable = true)
    private static void glBlendEquation(int blendEquation, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableOutlineMode", at = @At("HEAD"), cancellable = true)
    private static void enableOutlineMode(int color, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableOutlineMode", at = @At("HEAD"), cancellable = true)
    private static void disableOutlineMode(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableFog", at = @At("HEAD"), cancellable = true)
    private static void enableFog(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableFog", at = @At("HEAD"), cancellable = true)
    private static void disableFog(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "setFog(Lnet/minecraft/client/renderer/GlStateManager$FogMode;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void setFog(GlStateManager.FogMode mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setFog(I)V", at = @At("HEAD"), cancellable = true)
    private static void setFog(int param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setFogDensity", at = @At("HEAD"), cancellable = true)
    private static void setFogDensity(float param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setFogStart", at = @At("HEAD"), cancellable = true)
    private static void setFogStart(float param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setFogEnd", at = @At("HEAD"), cancellable = true)
    private static void setFogEnd(float param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glFog", at = @At("HEAD"), cancellable = true)
    private static void glFog(int pname, FloatBuffer param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glFogi", at = @At("HEAD"), cancellable = true)
    private static void glFogi(int pname, int param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableCull", at = @At("HEAD"), cancellable = true)
    private static void enableCull(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableCull", at = @At("HEAD"), cancellable = true)
    private static void disableCull(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "cullFace(Lnet/minecraft/client/renderer/GlStateManager$CullFace;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void cullFace(GlStateManager.CullFace cullFace, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "cullFace(I)V", at = @At("HEAD"), cancellable = true)
    private static void cullFace(int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glPolygonMode", at = @At("HEAD"), cancellable = true)
    private static void glPolygonMode(int face, int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "enablePolygonOffset",
        at = @At("HEAD"),
        cancellable = true)
    private static void enablePolygonOffset(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "disablePolygonOffset",
        at = @At("HEAD"),
        cancellable = true)
    private static void disablePolygonOffset(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "doPolygonOffset", at = @At("HEAD"), cancellable = true)
    private static void doPolygonOffset(float factor, float units, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableColorLogic", at = @At("HEAD"), cancellable = true)
    private static void enableColorLogic(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableColorLogic", at = @At("HEAD"), cancellable = true)
    private static void disableColorLogic(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "colorLogicOp(Lnet/minecraft/client/renderer/GlStateManager$LogicOp;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void colorLogicOp(GlStateManager.LogicOp logicOperation, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "colorLogicOp(I)V", at = @At("HEAD"), cancellable = true)
    private static void colorLogicOp(int opcode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableTexGenCoord", at = @At("HEAD"), cancellable = true)
    private static void enableTexGenCoord(GlStateManager.TexGen texGen, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableTexGenCoord", at = @At("HEAD"), cancellable = true)
    private static void disableTexGenCoord(GlStateManager.TexGen texGen, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "texGen(Lnet/minecraft/client/renderer/GlStateManager$TexGen;I)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void texGen(GlStateManager.TexGen texGen, int param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "texGen(Lnet/minecraft/client/renderer/GlStateManager$TexGen;ILjava/nio/FloatBuffer;)V",
        at = @At("HEAD"),
        cancellable = true)
    private static void texGen(GlStateManager.TexGen texGen, int pname, FloatBuffer params, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "setActiveTexture", at = @At("HEAD"), cancellable = true)
    private static void setActiveTexture(int texture, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableTexture2D", at = @At("HEAD"), cancellable = true)
    private static void enableTexture2D(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableTexture2D", at = @At("HEAD"), cancellable = true)
    private static void disableTexture2D(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexEnv", at = @At("HEAD"), cancellable = true)
    private static void glTexEnv(int target, int parameterName, FloatBuffer parameters, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexEnvi", at = @At("HEAD"), cancellable = true)
    private static void glTexEnvi(int target, int parameterName, int parameter, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexEnvf", at = @At("HEAD"), cancellable = true)
    private static void glTexEnvf(int target, int parameterName, float parameter, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexParameterf", at = @At("HEAD"), cancellable = true)
    private static void glTexParameterf(int target, int parameterName, float parameter, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexParameteri", at = @At("HEAD"), cancellable = true)
    private static void glTexParameteri(int target, int parameterName, int parameter, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glGetTexLevelParameteri", at = @At("HEAD"), cancellable = true)
    private static void glGetTexLevelParameteri(int target, int level, int parameterName, CallbackInfoReturnable<Integer> cir)
    {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "generateTexture", at = @At("HEAD"), cancellable = true)
    private static void generateTexture(CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "deleteTexture", at = @At("HEAD"), cancellable = true)
    private static void deleteTexture(int texture, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "bindTexture", at = @At("HEAD"), cancellable = true)
    private static void bindTexture(int texture, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexImage2D", at = @At("HEAD"), cancellable = true)
    private static void glTexImage2D(int target,
                                     int level,
                                     int internalFormat,
                                     int width,
                                     int height,
                                     int border,
                                     int format,
                                     int type,
                                     IntBuffer pixels,
                                     CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexSubImage2D", at = @At("HEAD"), cancellable = true)
    private static void glTexSubImage2D(int target,
                                        int level,
                                        int xOffset,
                                        int yOffset,
                                        int width,
                                        int height,
                                        int format,
                                        int type,
                                        IntBuffer pixels,
                                        CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glCopyTexSubImage2D", at = @At("HEAD"), cancellable = true)
    private static void glCopyTexSubImage2D(int target,
                                            int level,
                                            int xOffset,
                                            int yOffset,
                                            int x,
                                            int y,
                                            int width,
                                            int height,
                                            CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glGetTexImage", at = @At("HEAD"), cancellable = true)
    private static void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableNormalize", at = @At("HEAD"), cancellable = true)
    private static void enableNormalize(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableNormalize", at = @At("HEAD"), cancellable = true)
    private static void disableNormalize(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "shadeModel", at = @At("HEAD"), cancellable = true)
    private static void shadeModel(int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableRescaleNormal", at = @At("HEAD"), cancellable = true)
    private static void enableRescaleNormal(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableRescaleNormal", at = @At("HEAD"), cancellable = true)
    private static void disableRescaleNormal(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "viewport", at = @At("HEAD"), cancellable = true)
    private static void viewport(int x, int y, int width, int height, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "colorMask", at = @At("HEAD"), cancellable = true)
    private static void colorMask(boolean red, boolean green, boolean blue, boolean alpha, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "clearDepth", at = @At("HEAD"), cancellable = true)
    private static void clearDepth(double depth, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "clearColor", at = @At("HEAD"), cancellable = true)
    private static void clearColor(float red, float green, float blue, float alph, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "clear", at = @At("HEAD"), cancellable = true)
    private static void clear(int mask, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "matrixMode", at = @At("HEAD"), cancellable = true)
    private static void matrixMode(int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "loadIdentity", at = @At("HEAD"), cancellable = true)
    private static void loadIdentity(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "pushMatrix", at = @At("HEAD"), cancellable = true)
    private static void pushMatrix(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "popMatrix", at = @At("HEAD"), cancellable = true)
    private static void popMatrix(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "getFloat", at = @At("HEAD"), cancellable = true)
    private static void getFloat(int pname, FloatBuffer params, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "ortho", at = @At("HEAD"), cancellable = true)
    private static void ortho(double left, double right, double bottom, double top, double zNear, double zFar, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "rotate(FFFF)V", at = @At("HEAD"), cancellable = true)
    private static void rotate(float angle, float x, float y, float z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "scale(FFF)V", at = @At("HEAD"), cancellable = true)
    private static void scale(float x, float y, float z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "scale(DDD)V", at = @At("HEAD"), cancellable = true)
    private static void scale(double x, double y, double z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "translate(FFF)V", at = @At("HEAD"), cancellable = true)
    private static void translate(float x, float y, float z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "translate(DDD)V", at = @At("HEAD"), cancellable = true)
    private static void translate(double x, double y, double z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "multMatrix", at = @At("HEAD"), cancellable = true)
    private static void multMatrix(FloatBuffer matrix, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "rotate(Lorg/lwjgl/util/vector/Quaternion;)V", at = @At("HEAD"), cancellable = true)
    private static void rotate(Quaternion quaternionIn, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "color(FFFF)V", at = @At("HEAD"), cancellable = true)
    private static void color(float colorRed, float colorGreen, float colorBlue, float colorAlpha, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "color(FFF)V", at = @At("HEAD"), cancellable = true)
    private static void color(float colorRed, float colorGreen, float colorBlue, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexCoord2f", at = @At("HEAD"), cancellable = true)
    private static void glTexCoord2f(float sCoord, float tCoord, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glVertex3f", at = @At("HEAD"), cancellable = true)
    private static void glVertex3f(float x, float y, float z, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "resetColor", at = @At("HEAD"), cancellable = true)
    private static void resetColor(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glNormalPointer", at = @At("HEAD"), cancellable = true)
    private static void glNormalPointer(int type, int stride, ByteBuffer buffer, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexCoordPointer(IIII)V", at = @At("HEAD"), cancellable = true)
    private static void glTexCoordPointer(int size, int type, int stride, int buffer_offset, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glTexCoordPointer(IIILjava/nio/ByteBuffer;)V", at = @At("HEAD"), cancellable = true)
    private static void glTexCoordPointer(int size, int type, int stride, ByteBuffer buffer, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glVertexPointer(IIII)V", at = @At("HEAD"), cancellable = true)
    private static void glVertexPointer(int size, int type, int stride, int buffer_offset, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glVertexPointer(IIILjava/nio/ByteBuffer;)V", at = @At("HEAD"), cancellable = true)
    private static void glVertexPointer(int size, int type, int stride, ByteBuffer buffer, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glColorPointer(IIII)V", at = @At("HEAD"), cancellable = true)
    private static void glColorPointerHook(int size, int type, int stride, int buffer_offset, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glColorPointer(IIILjava/nio/ByteBuffer;)V", at = @At("HEAD"), cancellable = true)
    private static void glColorPointerHook(int size, int type, int stride, ByteBuffer buffer, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glDisableClientState", at = @At("HEAD"), cancellable = true)
    private static void glDisableClientState(int cap, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glEnableClientState", at = @At("HEAD"), cancellable = true)
    private static void glEnableClientState(int cap, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glBegin", at = @At("HEAD"), cancellable = true)
    private static void glBegin(int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "enableLighting", at = @At("HEAD"), cancellable = true)
    private static void glEnd(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glDrawArrays", at = @At("HEAD"), cancellable = true)
    private static void glDrawArrays(int mode, int first, int count, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glLineWidth", at = @At("HEAD"), cancellable = true)
    private static void glLineWidth(float width, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "callList", at = @At("HEAD"), cancellable = true)
    private static void callList(int list, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glDeleteLists", at = @At("HEAD"), cancellable = true)
    private static void glDeleteLists(int list, int range, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glNewList", at = @At("HEAD"), cancellable = true)
    private static void glNewList(int list, int mode, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glEndList", at = @At("HEAD"), cancellable = true)
    private static void glEndList(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glGenLists", at = @At("HEAD"), cancellable = true)
    private static void glGenLists(int range, CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "glPixelStorei", at = @At("HEAD"), cancellable = true)
    private static void glPixelStorei(int parameterName, int param, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glReadPixels", at = @At("HEAD"), cancellable = true)
    private static void glReadPixels(int x, int y, int width, int height, int format, int type, IntBuffer pixels, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glGetError", at = @At("HEAD"), cancellable = true)
    private static void glGetError(CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, -1);
    }

    @Inject(method = "glGetString", at = @At("HEAD"), cancellable = true)
    private static void glGetString(int name, CallbackInfoReturnable<String> cir) {
        Hooks.returnableHook(cir, "");
    }

    @Inject(method = "glGetInteger(ILjava/nio/IntBuffer;)V", at = @At("HEAD"), cancellable = true)
    private static void glGetInteger(int parameterName, IntBuffer parameters, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "glGetInteger(I)I", at = @At("HEAD"), cancellable = true)
    private static void glGetInteger(int parameterName, CallbackInfoReturnable<Integer> cir) {
        Hooks.returnableHook(cir, 0);
    }

    @Inject(method = "enableBlendProfile", at = @At("HEAD"), cancellable = true)
    private static void enableBlendProfile(GlStateManager.Profile p_187408_0_, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "disableBlendProfile", at = @At("HEAD"), cancellable = true)
    private static void disableBlendProfile(GlStateManager.Profile p_187408_0_, CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }
}