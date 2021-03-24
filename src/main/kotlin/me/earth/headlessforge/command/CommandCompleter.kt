package me.earth.headlessforge.command

import org.jline.reader.Candidate
import org.jline.reader.Completer
import org.jline.reader.LineReader
import org.jline.reader.ParsedLine

open class CommandCompleter: Completer {
    override fun complete(reader: LineReader?, line: ParsedLine?, candidates: MutableList<Candidate>?) {
        TODO("Implement when JLine CommandLine works.")
    }

}