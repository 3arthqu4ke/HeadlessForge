package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand
import me.earth.headlessforge.util.NetworkUtil
import java.lang.Thread.sleep

open class ConnectCommand: AbstractCommand(arrayOf(arrayOf("connect"), arrayOf("ip"))) {
    override fun execute(args: Array<String>, raw: String) {
        if (args.size == 1) {
            LOGGER.info("Please specify an IP!")
            return
        }

        NetworkUtil.disconnect("Disconnected.")
        Thread {run { sleep(100); MC.addScheduledTask { run { NetworkUtil.connect(args[1]) }}}}.start()
    }

    override fun getDescription(): String {
        return "Use this command to connect to a server."
    }
}