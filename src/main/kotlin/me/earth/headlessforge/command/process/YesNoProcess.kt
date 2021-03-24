package me.earth.headlessforge.command.process

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand

abstract class YesNoProcess: AbstractCommand(arrayOf(arrayOf("Y/N"))) {
    override fun execute(args: Array<String>, raw: String) {
        when (args[0].toLowerCase()) {
            "y", "yes", "ye", "ja", "yess", "oui", "j", "yea" -> onYes()
            "n", "no", "ni", "nl", "np", "nu", "nein", "non"  -> onNo()
            else -> {
                LOGGER.info("Expected Y/N or anything similar...")
                COMMAND.addCallback(this)
            }
        }
    }

    override fun getDescription(): String { return "This is a process. No Description provided." }

    abstract fun onYes()

    open fun onNo() { }
}