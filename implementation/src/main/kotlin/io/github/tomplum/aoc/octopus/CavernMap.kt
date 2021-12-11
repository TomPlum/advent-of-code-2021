package io.github.tomplum.aoc.octopus

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D
import java.util.*

class CavernMap(data: List<String>) : AdventMap2D<Octopus>() {
    init {
        var x = 0
        var y = 0
        data.forEach { row ->
            row.forEach { column ->
                addTile(Point2D(x, y), Octopus(column.toString().toInt()))
                x++
            }
            y++
            x = 0
        }
        AdventLogger.debug("Before any steps:")
        AdventLogger.debug(this)
    }

    fun getTotalFlashesAfterSteps(steps: Int): Int = (0 until steps).sumOf { step ->
        getDataMap().forEach { (pos, current) -> addTile(pos, Octopus(current.energy + 1)) }
        val toFlash = filterTiles { octopus -> octopus.energy > 9 }
        val hasFlashed = mutableListOf<Point2D>()
        var flashCount = 0
        val next = Stack<Point2D>()
        next.addAll(toFlash.keys)
        while(next.isNotEmpty()) {
            val current = next.pop()
            hasFlashed.add(current)
            addTile(current, Octopus(0))
            val adjacent = filterPoints(current.adjacent().toSet()).filterKeys { pos -> pos !in hasFlashed }
            adjacent.forEach { (pos, octopus) -> addTile(pos, Octopus(octopus.energy + 1)) }
            val afterFlashing = filterPoints(current.adjacent().toSet()).filterKeys { pos -> pos !in hasFlashed }
            val flashing = afterFlashing.filterValues { octopus -> octopus.energy > 9 }.filterKeys { pos -> pos !in hasFlashed && pos !in next }
            next.addAll(flashing.keys)
            flashCount++
        }
        AdventLogger.debug("After step ${step + 1}")
        AdventLogger.debug(this)
        flashCount
    }

    fun findSynchronisedFlashStep(): Int {
        var synchronised = false
        var step = 1
        while (!synchronised) {
            getDataMap().forEach { (pos, current) -> addTile(pos, Octopus(current.energy + 1)) }
            val toFlash = filterTiles { octopus -> octopus.energy > 9 }
            val hasFlashed = mutableListOf<Point2D>()
            var flashCount = 0
            val next = Stack<Point2D>()
            next.addAll(toFlash.keys)
            while(next.isNotEmpty()) {
                val current = next.pop()
                hasFlashed.add(current)
                addTile(current, Octopus(0))
                val adjacent = filterPoints(current.adjacent().toSet()).filterKeys { pos -> pos !in hasFlashed }
                adjacent.forEach { (pos, octopus) -> addTile(pos, Octopus(octopus.energy + 1)) }
                val afterFlashing = filterPoints(current.adjacent().toSet()).filterKeys { pos -> pos !in hasFlashed }
                val flashing = afterFlashing.filterValues { octopus -> octopus.energy > 9 }.filterKeys { pos -> pos !in hasFlashed && pos !in next }
                next.addAll(flashing.keys)
                flashCount++
            }

            if (getDataMap().values.all { octopus -> octopus.energy == 0 }) {
                synchronised = true
            } else {
                step++
            }
        }
        return step
    }

    override fun toString(): String {
        val yMin = yMin() ?: 0
        val yMax = yMax() ?: 0
        val xMin = xMin() ?: 0
        val xMax = xMax() ?: 0
        return (yMin..yMax).joinToString("\n") { y ->
            (xMin..xMax).joinToString("") { x ->
                val tile = getTile(Point2D(x, y), Octopus(0))
                if (tile.energy == 0) {
                    "${"\u001B[32m"}$tile${"\u001B[0m"}"
                } else {
                    tile.toString()
                }
            }
        }.plus("\n")
    }
}
