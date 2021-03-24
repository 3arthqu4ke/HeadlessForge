package me.earth.headlessforge.mixin.settings;

import me.earth.headlessforge.Globals;
import me.earth.headlessforge.inject.Hooks;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyBinding.class)
public abstract class MixinKeyBinding {
    @Redirect(
        method = "updateKeyBindState",
        at = @At(
            value = "INVOKE",
            target = "Lorg/lwjgl/input/Keyboard;isKeyDown(I)Z",
            remap = false))
    private static boolean isKeyDownHook(int key) {
        return Hooks.lambdaHook(() -> Globals.KEYBINDS.isPressed(key),
                                () -> Keyboard.isKeyDown(key));
    }

}
