package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand

open class HelpCommand: AbstractCommand(arrayOf(arrayOf("help"), arrayOf("command"))) {
    override fun execute(args: Array<String>, raw: String) {
        if (args.size == 1) {
            LOGGER.info("Start your message with a . to send chatmessages when ingame." +
                        " Use / or ./ to send normal minecraft commands." )
            for (command in COMMAND.getCommands()) {
                LOGGER.info(command.getArgs())
            }
        } else {
            val c = COMMAND.get(args[1].toLowerCase())
            if (c == null) LOGGER.info("No command for name " + args[1] + " was found.")
            else LOGGER.info(c.getDescription())
        }
    }

    override fun getDescription(): String {
        return "Use help to get a list of commands. Use help <command> to get more detailed help for a command."
    }

}