package io.github.tomplum.aoc.vent

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class OceanFloorMap(data: List<String>) : AdventMap2D<HydrothermalVent>() {
    init {
        data.forEach { entry ->
            AdventLogger.debug("Found line segment $entry\n")
            val line = entry.split(" -> ")
            val start = line[0].split(",").map { value -> value.toInt() }
            val end = line[1].split(",").map { value -> value.toInt() }

            val startPos = Point2D(start[0], start[1])
            val endPos = Point2D(end[0], end[1])

            if (startPos.x == endPos.x) {
                (startPos.y.toward(endPos.y)).forEach { y ->
                    AdventLogger.debug("Plotting (${startPos.x}, $y)")
                    addVentLocation(Point2D(startPos.x, y))
                }
            }

            if (startPos.y == endPos.y) {
                (startPos.x.toward(endPos.x)).forEach { x ->
                    AdventLogger.debug("Plotting ($x, ${startPos.y})")
                    addVentLocation(Point2D(x, startPos.y))
                }
            }
        }
        AdventLogger.info(this)
    }

    fun getDangerousVentCount(): Int {
        return filterTiles { vent -> vent.value >= 2 }.count()
    }

    private fun addVentLocation(pos: Point2D) {
        val existing = filterPoints(setOf(pos))
        if (existing.isNotEmpty()) {
            val existingQuantity = existing.values.first().value
            addTile(pos, HydrothermalVent(existingQuantity + 1))
        } else {
            addTile(pos, HydrothermalVent(1))
        }
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }
}
