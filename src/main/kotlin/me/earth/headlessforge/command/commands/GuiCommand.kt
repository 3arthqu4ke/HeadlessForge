package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.GUI
import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand
import me.earth.headlessforge.inject.ducks.IGuiScreen

open class GuiCommand: AbstractCommand(arrayOf(arrayOf("gui"))) {
    override fun execute(args: Array<String>, raw: String) {
        if (MC.currentScreen == null) {
            LOGGER.info("The current screen is null!")
            return
        }
        GUI.dumpButtons(MC.currentScreen as IGuiScreen)
    }

    override fun getDescription(): String {
        return "Get info about the currently displayed gui."
    }

}