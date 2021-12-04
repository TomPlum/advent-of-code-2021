package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D
import io.github.tomplum.libs.solutions.benchmark.report.coloured

class BingoBoard : AdventMap2D<BingoNumber>() {
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
                    "${"\u001B[32m"}$tile${"\u001B[0m"}"
                } else {
                    tile.toString()
                }
            }
        }.plus("\n")
    }
}
