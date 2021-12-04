package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.logging.AdventLogger

class Bingo(data: List<String>) {

    private val numbers = data.first().trim().split(",").map { value -> value.toInt() }
    private val boards = data
        .drop(2)
        .filterNot { value -> value == "" }
        .chunked(5)
        .mapIndexed { i, data -> BingoBoard.fromString(i + 1, data) }

    fun playUntilFirstWinner(): Int {
        numbers.forEach { number ->
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
        val winStates = mutableMapOf<Int, Boolean>()
        boards.forEach { board ->
            winStates[board.id] = false
        }

        numbers.forEach { number ->
            boards.forEach { board ->
                board.drawNumber(number)
                if (board.hasWinningState()) {
                    winStates[board.id] = true

                    if(winStates.values.all { hasWon -> hasWon }) {
                        return board.getUnMarkedNumbers().sum() * number
                    }
                }
            }
        }

        throw IllegalArgumentException("All numbers were drawn but nobody won!")
    }
}
