package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.api.command.AbstractCommand
import me.earth.headlessforge.command.process.TicTacToeProcess

open class TicTacToeCommand: AbstractCommand(arrayOf(arrayOf("tictactoe"))) {
    override fun execute(args: Array<String>, raw: String) {
        TicTacToeProcess.startGame()
        TicTacToeProcess.printBoard()
        COMMAND.addCallback(TicTacToeProcess)
    }

    override fun getDescription(): String {
        return "Use this command to play TicTacToe."
    }

}