package me.earth.headlessforge.command

import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.ICommand
import me.earth.headlessforge.api.command.ICommandManager
import me.earth.headlessforge.command.commands.*
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CopyOnWriteArrayList

open class CommandManager: ICommandManager {
    private val commands: MutableList<ICommand> = CopyOnWriteArrayList(arrayOf(HelpCommand()))
    private val callbacks: Queue<ICommand> = ConcurrentLinkedQueue()

    init {
        commands.add(QuitCommand())
        commands.add(TicTacToeCommand())
        commands.add(DisconnectCommand())
        commands.add(ConnectCommand())
        commands.add(GuiCommand())
        commands.add(ClickCommand())
        commands.add(TextCommand())
        commands.add(RamCommand())
        commands.add(SessionCommand())
    }

    override fun execute(msg: String) {
        if (msg.isEmpty() || msg == "." || msg == "/") {
            LOGGER.info("Please specify a message!")
            return
        }

        val args = split(msg)
        if (args.isEmpty()) {
            return
        }

        if (callbacks.isNotEmpty()) {
            MC.addScheduledTask { run {
                callbacks.poll().execute(args, msg)
            }}
            return
        }

        if (msg.startsWith(".") || msg.startsWith("/")) {
            MC.addScheduledTask { run {
                if (MC.player == null) {
                    LOGGER.info("You need to be ingame to send a chatmessage!")
                } else {
                    MC.player.sendChatMessage(if (msg.startsWith(".")) msg.substring(1) else msg)
                }
            }}
            return
        }

        for (command in commands) {
            if (command.matches(args, msg)) {
                MC.addScheduledTask { run {
                    command.execute(args, msg)
                }}
                return
            }
        }

        var distance = Integer.MAX_VALUE
        var closest: ICommand = commands[0]
        for (command in commands) {
            val dist = levenshtein(args[0], command.getName())
            if (dist < distance) {
                distance = dist
                closest = command
            }
        }

        LOGGER.info("No command found. Did you mean " + closest.getName() + "?")
    }

    override fun addCallback(callback: ICommand) {
        callbacks.add(callback)
    }

    override fun get(name: String): ICommand? {
        return commands.firstOrNull { c -> c.getName() == name }
    }

    override fun add(command: ICommand) {
        commands.add(command)
    }

    override fun remove(command: ICommand) {
        commands.remove(command)
    }

    override fun getCommands(): Collection<ICommand> {
        return commands
    }
}