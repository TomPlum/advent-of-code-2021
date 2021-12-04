package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D
import io.github.tomplum.libs.solutions.benchmark.report.coloured

class BingoBoard(val id: Int) : AdventMap2D<BingoNumber>() {

    companion object {
        fun fromString(id: Int, data: List<String>): BingoBoard {
            val board = BingoBoard(id)
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
            return board
        }
    }

    fun addNumber(pos: Point2D, tile: BingoNumber) {
        addTile(pos, tile)
    }

    fun drawNumber(number: Int) {
        val matching = filterTiles { tile -> tile.number == number }
        if (matching.isNotEmpty()) {
            val (pos, number) = matching.entries.first()
            number.setHasBeenDrawn()
            addNumber(pos, number)
        }
    }

    fun getUnMarkedNumbers(): Set<Int> {
        return filterTiles { tile -> !tile.hasBeenDrawn }.map { tile -> tile.value.value }.toSet()
    }

    fun hasWinningState(): Boolean {
        val yMin = yMin() ?: 0
        val yMax = yMax() ?: 0
        val xMin = xMin() ?: 0
        val xMax = xMax() ?: 0

        // Check rows
        (yMin..yMax).forEach { y ->
            val wasDrawn = mutableListOf<Boolean>()
            (xMin..xMax).forEach { x ->
                wasDrawn.add(getTile(Point2D(x, y)).hasBeenDrawn)
            }
            if (wasDrawn.all { it }) {
                return true
            }
        }

        // Check columns
        (xMin..xMax).forEach { x ->
            val wasDrawn = mutableListOf<Boolean>()
            (yMin..yMax).forEach { y ->
                wasDrawn.add(getTile(Point2D(x, y)).hasBeenDrawn)
            }
            if (wasDrawn.all { it }) {
                return true
            }
        }

        return false
    }

    override fun toString(): String {
        val yMin = yMin() ?: 0
        val yMax = yMax() ?: 0
        val xMin = xMin() ?: 0
        val xMax = xMax() ?: 0
        return (yMin..yMax).joinToString("\n") { y ->
            (xMin..xMax).joinToString(" ") { x ->
                val tile = getTile(Point2D(x, y), BingoNumber(0))
                if (tile.hasBeenDrawn) {
                    "${"\u001B[32m"}$tile${"\u001B[0m"}".padStart(2, ' ')
                } else {
                    tile.toString().padStart(2, ' ')
                }
            }
        }.plus("\n")
    }
}
