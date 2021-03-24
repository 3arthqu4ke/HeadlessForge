package me.earth.headlessforge.api.command

/**
 * A CommandManager that can register Commands
 * and execute messages.
 */
interface ICommandManager {
    /** Finds a Command for the given String and executes it. */
    fun execute(msg: String)

    /**
     * Add a command that will always be executed first when the execute method is called.
     * Useful for stuff like Yes/No questions.
     */
    fun addCallback(callback: ICommand)

    /** Attempts to get an added command with the given name. */
    fun get(name: String): ICommand?

    /** Adds a command. */
    fun add(command: ICommand)

    /** Removes a command. */
    fun remove(command: ICommand)

    /** Returns a mutable collection of all added commands. */
    fun getCommands(): Collection<ICommand>

}