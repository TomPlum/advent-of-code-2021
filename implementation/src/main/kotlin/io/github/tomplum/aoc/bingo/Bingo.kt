package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D

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

        return 0
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

        return 0
    }

    private fun getNumbers() = data.first().trim().split(",").map { value -> value.toInt() }

    private fun getBingoBoards() = data.drop(2).filterNot { it == "" }.chunked(5).mapIndexed { i, data ->
        val board = BingoBoard(i + 1)
        var x = 0
        var y = 0
        data.forEach { row ->
            row.split(" ").filterNot { it == "" }.forEach { col ->
                board.addNumber(Point2D(x, y), BingoNumber(col.trim().toInt()))
                x++
            }
            x = 0
            y++
        }
        board
    }
}
