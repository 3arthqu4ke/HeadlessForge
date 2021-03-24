package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.api.command.AbstractCommand

open class QuitCommand: AbstractCommand(arrayOf(arrayOf("quit"))) {
    override fun execute(args: Array<String>, raw: String) {
        MC.shutdown()
    }

    override fun getDescription(): String {
        return "Use the quit command to turn off the client."
    }

}