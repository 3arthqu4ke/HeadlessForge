package me.earth.headlessforge.mixin;

import com.google.common.hash.Hashing;
import com.mojang.authlib.GameProfile;
import me.earth.headlessforge.Globals;
import me.earth.headlessforge.inject.Hooks;
import me.earth.headlessforge.inject.replace.EmptyFontRenderer;
import me.earth.headlessforge.inject.replace.EmptyFrameBuffer;
import me.earth.headlessforge.inject.replace.EmptyRenderGlobal;
import me.earth.headlessforge.inject.replace.EmptyRenderItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.profiler.Snooper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    private static final Logger LOGGER = LogManager.getLogger("HeadlessForge");

    @Shadow
    @Final
    private Session session;

    @Shadow
    public abstract void updateDisplay();

    @Inject(
        method = "setInitialDisplayMode()V",
        at = @At("HEAD"),
        cancellable = true)
    private void setInitialDisplayModeHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
        method = "run",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/Minecraft;init()V",
            shift = At.Shift.AFTER))
    private void runHook(CallbackInfo ci) {
        Globals.CONSOLE.attach(Minecraft.getMinecraft());
    }

    @Inject(
        method = "createDisplay",
        at = @At("HEAD"),
        cancellable = true)
    private void createDisplayHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/OpenGlHelper;initializeTextures()V"))
    private void initializeTexturesHook() {
        Hooks.RUN_HOOK.invoke(OpenGlHelper::initializeTextures);
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "NEW",
            target = "net/minecraft/client/shader/Framebuffer"))
    private Framebuffer replaceFrameBuffer(int width, int height, boolean useDepthIn)  {
        return Hooks.lambdaHook(() -> new EmptyFrameBuffer(width, height, useDepthIn),
                                  () -> new Framebuffer(width, height, useDepthIn));
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "NEW",
            target = "net/minecraft/client/gui/FontRenderer"))
    private FontRenderer replaceFontRenderer(GameSettings gameSettingsIn,
                                             ResourceLocation location,
                                             TextureManager textureManagerIn,
                                             boolean unicode) {
        return Hooks.lambdaHook(
                () -> new EmptyFontRenderer(gameSettingsIn, location, textureManagerIn, unicode),
                () -> new FontRenderer(gameSettingsIn, location, textureManagerIn, unicode));
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "NEW",
            target = "net/minecraft/client/renderer/RenderItem"))
    private RenderItem renderItemHook(TextureManager p_i46552_1_,
                                      ModelManager p_i46552_2_,
                                      ItemColors p_i46552_3_) {
        return Hooks.lambdaHook(
                () -> new EmptyRenderItem(p_i46552_1_, p_i46552_2_, p_i46552_3_),
                () -> new RenderItem(p_i46552_1_, p_i46552_2_, p_i46552_3_));
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "NEW",
            target = "net/minecraft/client/renderer/RenderGlobal"))
    private RenderGlobal renderGlobalHook(Minecraft mc) {
        return Hooks.lambdaHook(() -> new EmptyRenderGlobal(mc), () -> new RenderGlobal(mc));
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;setVSyncEnabled(Z)V",
            remap = false))
    private void setVSyncEnabledHook(boolean sync) {
        Hooks.RUN_HOOK.invoke(() -> Display.setVSyncEnabled(sync));
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;isCreated()Z",
            remap = false))
    private boolean isCreated() {
        return Hooks.lambdaHook(() -> false, Display::isCreated);
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;sync(I)V",
            remap = false))
    private void syncHook(int fps) {
        Hooks.RUN_HOOK.invoke(() -> Display.sync(fps));
    }

    @Redirect(
        method = "addServerStatsToSnooper",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;getDisplayMode()Lorg/lwjgl/opengl/DisplayMode;",
            remap = false))
    private DisplayMode getDisplayModeHook() {
        return Hooks.lambdaHook(() -> new DisplayMode(0, 0), Display::getDisplayMode);
    }

    @Inject(
        method = "checkGLError",
        at = @At("HEAD"),
        cancellable = true)
    private void checkGLErrorHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
            method = "drawSplashScreen",
            at = @At("HEAD"),
            cancellable = true)
    private void drawSplashScreenHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(
            method = "updateDisplayMode",
            at = @At("HEAD"),
            cancellable = true)
    private void updateDisplayModeHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/EntityRenderer;updateCameraAndRender(FJ)V")
    )
    private void updateCameraAndRenderHook(EntityRenderer entityRenderer,
                                           float partialTicks,
                                           long nanoTime) {
        Hooks.RUN_HOOK.invoke(() ->
                entityRenderer.updateCameraAndRender(partialTicks, nanoTime));
    }

    @Inject(method = "checkWindowResize", at = @At("HEAD"), cancellable = true)
    private void checkWindowResizeHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/Minecraft;updateDisplay()V")
    )
    private void updateDisplayHook(Minecraft minecraft) {
        Hooks.RUN_HOOK.invoke(this::updateDisplay);
    }

    @Inject(
        method = "getSystemTime",
        at = @At("HEAD"),
        cancellable = true)
    private static void getSystemTimeHook(CallbackInfoReturnable<Long> info) {
        // TODO: This is a bad
        Hooks.returnableHook(info, System.nanoTime() / 1000000);
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/toasts/GuiToast;drawToast(Lnet/minecraft/client/gui/ScaledResolution;)V"))
    private void toastHook(GuiToast guiToast, ScaledResolution resolution) {
        Hooks.RUN_HOOK.invoke(() -> guiToast.drawToast(resolution));
    }

    @Inject(
        method = "displayDebugInfo",
        at = @At("HEAD"),
        cancellable = true)
    private void displayDebugInfoHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "displayGuiScreen",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/input/Mouse;next()Z",
            remap = false))
    private boolean mouseHook() {
        return Hooks.lambdaHook(() -> false, Mouse::next);
    }

    @Redirect(
        method = "displayGuiScreen",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/input/Keyboard;next()Z",
            remap = false))
    private boolean keyboardHook() {
        return Hooks.lambdaHook(() -> false, Keyboard::next);
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/Sys;getVersion()Ljava/lang/String;",
            remap = false))
    private String getVersionHook() {
        return Hooks.lambdaHook(() -> "Hooks are active, no LWJGL context.", Sys::getVersion);
    }

    @Inject(method = "setWindowIcon", at = @At("HEAD"), cancellable = true)
    private void windowIconHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @SuppressWarnings({"ConstantConditions", "UnstableApiUsage", "deprecation"})
    @Inject(method = "addServerTypeToSnooper", at = @At(value = "HEAD"), cancellable = true)
    private void addServerTypeToSnooperHook(Snooper snooper, CallbackInfo ci) {
        if (Hooks.active()) {
            GameProfile gameprofile = this.session.getProfile();
            if (gameprofile != null && gameprofile.getId() != null) {
                snooper.addStatToSnooper(
                        "uuid", Hashing.sha1()
                                .hashBytes(gameprofile.getId()
                                        .toString()
                                        .getBytes(Charsets.ISO_8859_1))
                                .toString());
            }

            ci.cancel();
        }
    }

    @Inject(method = "runTickMouse", at = @At("HEAD"), cancellable = true)
    private void runTickMouseHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Inject(method = "runTickKeyboard", at = @At("HEAD"), cancellable = true)
    private void runTickKeyboardHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "setIngameFocus",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;isActive()Z",
            remap = false))
    private boolean ingameFocusHook() {
        return Hooks.lambdaHook(() -> true, Display::isActive);
    }

    @Inject(method = "toggleFullscreen", at = @At("HEAD"), cancellable = true)
    private void toggleFullscreenHook(CallbackInfo ci) {
        Hooks.DEFAULT_HOOK.invoke(ci);
    }

    @Redirect(
        method = "shutdownMinecraftApplet",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/opengl/Display;destroy()V",
            remap = false))
    private void shutdownMinecraftAppletHook() {
        Hooks.RUN_HOOK.invoke(Display::destroy);
    }

    @Inject(method = "displayGuiScreen", at = @At("HEAD"))
    private void displayGuiScreenHook(GuiScreen guiScreenIn, CallbackInfo ci) {
        LOGGER.info("Now displaying GuiScreen: "
                        + (guiScreenIn == null
                             ? "null"
                             : guiScreenIn.getClass().getSimpleName()) + ".");
    }

    @Redirect(
        method = "runGameLoop",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/Thread;yield()V"))
    private void yieldHook()
    {
        /*
            This looks kinda bad, but it seems that without
            the Display.update() call the game loop kinda
            "runs hot". Meaning that after ca. 1-2 minutes
            the game starts lagging. I'm afraid to touch this
            since it works now.
         */

        try
        {
            if (Hooks.active())
            {
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        Thread.yield();
    }

}