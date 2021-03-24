package me.earth.headlessforge.gui

import me.earth.headlessforge.api.gui.IKeyBind

open class KeyBindProvider: IKeyBind {
    private val binds: MutableMap<Int, Boolean> = HashMap()

    override fun setPressed(id: Int, pressed: Boolean) {
        binds[id] = pressed
    }

    override fun isPressed(id: Int): Boolean {
        return binds[id]?: false
    }

}