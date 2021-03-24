package me.earth.headlessforge.api.command

@Suppress("UNUSED") // TODO: Use this once Completer and JLine Console work?
data class CommandInput(val raw: String, val args: Array<String>, val withEscapes: Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommandInput

        if (raw != other.raw) return false
        if (!args.contentEquals(other.args)) return false
        if (!withEscapes.contentEquals(other.withEscapes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = raw.hashCode()
        result = 31 * result + args.contentHashCode()
        result = 31 * result + withEscapes.contentHashCode()
        return result
    }
}
