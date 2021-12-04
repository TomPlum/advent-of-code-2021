package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.logging.AdventLogger

class Bingo(private val data: List<String>) {
    fun play(): Int {
        val order = getNumbers()
        val boards = getBingoBoards()

        order.forEach { number ->
            boards.forEach { board ->
                board.drawNumber(number)
                if (board.hasWinningState()) {
                    AdventLogger.info("Board ${board.id}: BINGO!")
                    AdventLogger.info(board)
                    return board.getUnMarkedNumbers().sum() * number
                }
            }
        }

        throw IllegalArgumentException("All numbers were drawn but nobody won!")
    }

    fun playUntilLastWinner(): Int {
        val order = getNumbers()
        val boards = getBingoBoards()

        val winStates = mutableMapOf<Int, Boolean>()
        boards.forEach { board ->
            winStates[board.id] = false
        }

        order.forEach { number ->
            boards.forEach { board ->
                board.drawNumber(number)
                if (board.hasWinningState()) {
                    winStates[board.id] = true

                    if(winStates.values.all { it }) {
                        return board.getUnMarkedNumbers().sum() * number
                    }
                }
            }
        }

        throw IllegalArgumentException("All numbers were drawn but nobody won!")
    }

    private fun getNumbers() = data.first().trim().split(",").map { value -> value.toInt() }

    private fun getBingoBoards() = data
        .drop(2)
        .filterNot { value -> value == "" }
        .chunked(5)
        .mapIndexed { i, data -> BingoBoard.fromString(i + 1, data) }
}
