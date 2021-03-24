package me.earth.headlessforge.command.process

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand
import java.util.*

object TicTacToeProcess: AbstractCommand(arrayOf(arrayOf("TicTacToe"))) {
    private val board = Array(9) { "   " }
    private val rnd = Random()
    override fun execute(args: Array<String>, raw: String) {
        when (args[0].toLowerCase()) {
            "stop" -> { LOGGER.info("Stopping TicTacToe..."); return }
            "help" -> LOGGER.info(getDescription())
            "reset" -> { startGame(); printBoard() }
            "board" -> printBoard()
            else -> {
                try {
                    val i = args[0].toInt()
                    if (i >= board.size || i < 0) {
                        throw NumberFormatException()
                    }
                    board[i] = " x "; printBoard(); if (nextMove()) return; printBoard()
                } catch (nfe: NumberFormatException) {
                    LOGGER.info("Please use a number from 0-8.")
                }
            }
        }
        COMMAND.addCallback(this)
    }

    override fun getDescription(): String {
        return "You can play TicTacToe with following inputs: <stop/help/0-8/board/reset>." +
                " The board is enumerated like this:\n+---+---+---+\n| 0 | 1 | 2 |\n+---+---+---+" +
                "\n| 3 | 4 | 5 |\n+---+---+---+\n| 6 | 7 | 8 |\n+---+---+---+\n"
    }

    fun startGame() {
        for (i in board.indices) { board[i] = "   " }
        if (rnd.nextBoolean()) { LOGGER.info("I start! Type \"help\" for help."); nextMove() }
        else LOGGER.info("You start! Type \"help\" for help.")
    }

    fun printBoard() {
        val builder = StringBuilder("\n")
        for (i in board.indices) {
            if (i % 3 == 0) { builder.append("\n+---+---+---+\n|") }
            builder.append(board[i]).append("|")
        }
        LOGGER.info(builder.append("\n+---+---+---+\n").toString())
    }

    private fun nextMove(): Boolean {
        checkWin()?.let { s -> printBoard(); LOGGER.info(s); return true }

        for (i in board.indices) { // TODO: TicTacToe AI
            if (board[i] == "   ") {
                board[i] = " o "
                break
            }
        }

        checkWin()?.let { s -> printBoard(); LOGGER.info(s); return true }
        return false
    }

    private fun checkWin(): String? {
        var full = board[7] != "   "
        for (win in arrayOf(arrayOf(0, 3, 6), arrayOf(1, 0, 2), arrayOf(2, 4, 6), arrayOf(3, 4, 5),
                            arrayOf(4, 1, 7), arrayOf(5, 2, 8), arrayOf(6, 7, 8), arrayOf(8, 4, 0)))
            if (board[win[0]] != "   ".also { full = full && board[win[0]] != "   " }
                && board[win[0]] == board[win[1]] && board[win[0]] == board[win[2]]) {
                return if ((board[win[0]]) == " x ") "You win!" else "I win!"
            }
        return if (full) "It's a draw!" else null
    }

}