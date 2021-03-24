package me.earth.headlessforge.api.command

abstract class AbstractCommand(args: Array<Array<String>>): ICommand {
    private val arguments: Array<Array<String>> = verifyArgs(args)

    override fun matches(args: Array<String>, raw: String): Boolean {
        return args[0] == this.arguments[0][0]
    }

    override fun getName(): String {
        return arguments[0][0]
    }

    override fun getArgs(): String {
        return concatHelp(arguments)
    }
}