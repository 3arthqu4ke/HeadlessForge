package me.earth.headlessforge.command.commands

import me.earth.headlessforge.api.command.AbstractCommand
import me.earth.headlessforge.util.NetworkUtil

open class DisconnectCommand: AbstractCommand(arrayOf(arrayOf("disconnect"))) {
    override fun execute(args: Array<String>, raw: String) {
        NetworkUtil.disconnect("Disconnected.")
    }

    override fun getDescription(): String {
        return "Use this command to connect to a server."
    }
}