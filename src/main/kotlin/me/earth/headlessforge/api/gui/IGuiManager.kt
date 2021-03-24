package me.earth.headlessforge.api.gui

import me.earth.headlessforge.inject.ducks.IGuiScreen
import net.minecraft.client.gui.GuiScreen

/** Supports getting info about GuiScreens, clicking Buttons and setting Textfields in them. */
interface IGuiManager {
    /** Outputs GuiButtons and TextFields belonging to the given GuiScreen on the console. */
    fun dumpButtons(gui: IGuiScreen)

    /** Clicks the GuiButton with the given ID with the given MouseButton. */
    fun clickButton(gui: IGuiScreen, id: Int, mouseButton: Int): String

    /** Sets the Text inside the Textfield belonging to the given ID. */
    fun setTextField(gui: GuiScreen, fieldID: Int, text: String)

}