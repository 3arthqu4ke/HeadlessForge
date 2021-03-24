package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.GUI
import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand
import me.earth.headlessforge.inject.ducks.IGuiScreen

open class ClickCommand: AbstractCommand(arrayOf(arrayOf("click"), arrayOf("button"))) {
    override fun execute(args: Array<String>, raw: String) {
        when {
            MC.currentScreen == null -> { LOGGER.info("The current screen is null!") }
            args.size == 1 -> { LOGGER.info("Please specify a button to click.") }
            else -> {
                try {
                    val screen = MC.currentScreen
                    val id = args[1].toLong()
                    LOGGER.info(GUI.clickButton(screen as IGuiScreen, id.toInt(), 0))
                } catch (nfe: NumberFormatException) {
                    LOGGER.info("Couldn't parse " + args[1] + ". Please provide a number!")
                }
            }
        }
    }

    override fun getDescription(): String {
        return "Click a GuiButton. To obtain the ID to click use the \"gui\" command."
    }
}