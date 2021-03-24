package me.earth.headlessforge.launch

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.console.IConsole
import me.earth.headlessforge.command.CommandCompleter
import net.minecraft.client.Minecraft
import net.minecraftforge.server.terminalconsole.TerminalConsoleAppender
import org.jline.reader.EndOfFileException
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.UserInterruptException

@Suppress("unused")
open class ConsoleJLine: IConsole {
    private var attached = false

    override fun attach(mc: Minecraft) {
        if (attached) {
            LOGGER.warn("Console is already attached!")
            return
        }

        LOGGER.info("Attaching Console...")
        attached = true
        val terminal = TerminalConsoleAppender.getTerminal()!! // <----------- TODO: make work :(
        val reader = LineReaderBuilder.builder()
                                      .appName("HeadlessForge")
                                      .terminal(terminal)
                                      .completer(CommandCompleter())
                                      .build()

        reader.setOpt(LineReader.Option.DISABLE_EVENT_EXPANSION)
        reader.unsetOpt(LineReader.Option.INSERT_TAB)
        TerminalConsoleAppender.setReader(reader)

        val thread = Thread({
            run {
                try {
                    var line: String?
                    while (true) {
                        line = try {
                            reader.readLine("> ")
                        } catch (ignored: EndOfFileException) {
                            continue
                        }

                        if (line == null) {
                            break
                        }

                        line = line.trim { it <= ' ' }
                        if (line.isNotEmpty()) {
                            COMMAND.execute(line.trim())
                        }
                    }
                } catch (e: UserInterruptException) {
                    mc.shutdown()
                } finally {
                    TerminalConsoleAppender.setReader(null)
                }
            }
        }, "HeadlessForge-ConsoleThread")

        thread.isDaemon = true
        thread.start()
    }

}