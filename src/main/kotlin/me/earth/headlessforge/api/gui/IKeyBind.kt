package me.earth.headlessforge.api.gui

import net.minecraft.client.settings.KeyBinding

/** Represents [KeyBinding]. */
interface IKeyBind {
    /** The isPressed method will now return the given value for the given keycode. */
    fun setPressed(id: Int, pressed: Boolean)

    /** @return the value the setPressed method was used with for the keycode. */
    fun isPressed(id: Int): Boolean

}