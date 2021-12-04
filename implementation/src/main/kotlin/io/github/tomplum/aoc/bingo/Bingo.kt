package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.map.MapTile
import io.github.tomplum.libs.math.point.Point2D

class Bingo(val data: List<String>) {
    fun play(): Int {
        val order = data.first().trim().split(",").map { value -> value.toInt() }
        val boards = data.drop(2).filterNot { it == "" }.chunked(5).map { data ->
            val board = BingoBoard()
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

        order.forEach { number ->
            boards.forEach { board ->
                board.drawNumber(number)
                if (board.hasWinningState()) {
                    println(board)
                    return board.getUnMarkedNumbers().sum() * number
                }
            }
        }

        return 0
    }
}
