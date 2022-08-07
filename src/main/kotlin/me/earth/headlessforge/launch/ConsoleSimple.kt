package me.earth.headlessforge.launch

import me.earth.headlessforge.Globals
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.console.IConsole
import net.minecraft.client.Minecraft
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

/**
 * A simple console.
 */
open class ConsoleSimple: IConsole {
    private var attached = false

    override fun attach(mc: Minecraft) {
        if (System.getProperty("headlessforge.no.console", "false").toBoolean()) {
            LOGGER.warn("Not attaching HeadlessForge console!")
            return
        }

        if (attached) {
            LOGGER.warn("Console is already attached!")
            return
        }

        LOGGER.info("Attaching Console...")
        attached = true
        val thread = Thread({
            run {
                val reader = BufferedReader(InputStreamReader(System.`in`, StandardCharsets.UTF_8))
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    line?.let { Globals.COMMAND.execute(it) }
                }
                Globals.MC.shutdown()
            }
        }, "HeadlessForge-ConsoleThread")

        thread.isDaemon = true
        thread.start()
    }
}