package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.GUI
import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand

open class TextCommand: AbstractCommand(arrayOf(arrayOf("text"), arrayOf("textField"), arrayOf("text"))) {
    override fun execute(args: Array<String>, raw: String) {
        val screen = MC.currentScreen
        if (screen == null) {
            LOGGER.info("The current screen is null!")
            return
        }

        if (args.size == 1) {
            LOGGER.info("Please specify an ID!")
            return
        }

        try {
            val id = args[1].toInt()
            GUI.setTextField(screen, id, raw.replaceFirst(args[0], "").replaceFirst(args[1], "").trim())
        } catch (nfe: NumberFormatException) {
            LOGGER.info("Couldn't parse " + args[1] + ". Please specify a number!")
        }
    }

    override fun getDescription(): String {
        return "Allows you to set the Text of TextFields in the Gui." +
                " Get the IDs for the TextField from the gui command." +
                " Escaping whitespaces in the text is not required."
    }

}