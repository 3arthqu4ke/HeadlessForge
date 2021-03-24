package me.earth.headlessforge.command.commands

import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand

class RamCommand: AbstractCommand(arrayOf(arrayOf("ram"))) {
    override fun execute(args: Array<String>, raw: String) {
        val total = (Runtime.getRuntime().totalMemory() / 1024L / 1024L)
        val free  = (Runtime.getRuntime().freeMemory()  / 1024L / 1024L)
        val max   = (Runtime.getRuntime().maxMemory()   / 1024L / 1024L)
        val usedMemory  = total - free
        val usedPercent = usedMemory * 100L / (max.toFloat())

        LOGGER.info("-Used:  " + usedMemory + "mb, (" + usedPercent + "%)")
        LOGGER.info("-Free:  " + free + "mb")
        LOGGER.info("-Total: " + total + "mb")
        LOGGER.info("-Max:   " + max + "mb")
    }

    override fun getDescription(): String {
        return "Displays info about allocated and used memory."
    }

}