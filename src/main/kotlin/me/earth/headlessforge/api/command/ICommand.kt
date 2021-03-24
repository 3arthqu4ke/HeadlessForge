package me.earth.headlessforge.api.command

fun verifyArgs(args: Array<Array<String>>): Array<Array<String>> {
    if (args.isEmpty() || args[0].size != 1) {
        throw IllegalArgumentException("Commands Args need to be an Array of StringArrays where the first entry " +
                "represents the name of the command and has a length of 1!")
    }
    return args
}

fun concatHelp(args: Array<Array<String>>): String {
    val builder = StringBuilder()
    for (i in args.indices) {
        if (i == 0) {
            builder.append(args[0][0])
            continue
        }
        builder.append(" <")
        for (j in args[i].indices) {
            builder.append(args[i][j])
            if (j != args[i].size - 1) {
                builder.append("/")
            }
        }
        builder.append(">")
    }
    return builder.toString()
}

/** Represents a Command that can be executed. */
interface ICommand {
    fun execute(args: Array<String>, raw: String)

    fun matches(args: Array<String>, raw: String): Boolean

    fun getName(): String

    fun getArgs(): String

    fun getDescription(): String

}