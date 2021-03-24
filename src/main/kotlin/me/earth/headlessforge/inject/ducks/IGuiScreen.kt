package me.earth.headlessforge.inject.ducks

import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import java.io.IOException

/**
 * Duck Interface for [GuiScreen]
 */
interface IGuiScreen {
    /** @return access the buttonlist of the Gui. */
    fun getButtons(): List<GuiButton>?

    /** Invokes the keyTyped method of the GuiScreen. */
    fun invokeKeyTyped(typedChar: Char, keyCode: Int)

    /** Invokes the mouseClick method of the GuiScreen. */
    @Throws(IOException::class)
    fun invokeMouseClick(mouseX: Int, mouseY: Int, mouseButton: Int)

}