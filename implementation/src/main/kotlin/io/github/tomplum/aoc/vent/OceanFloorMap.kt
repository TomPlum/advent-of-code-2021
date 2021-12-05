package io.github.tomplum.aoc.vent

import io.github.tomplum.aoc.vent.strategy.VentMappingStrategy
import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class OceanFloorMap(data: List<String>, mappingStrategy: VentMappingStrategy) : AdventMap2D<HydrothermalVent>() {
    init {
        data.forEach { entry ->
            AdventLogger.debug("Found line segment $entry\n")
            val line = entry.split(" -> ")
            val start = line[0].split(",").map { value -> value.toInt() }
            val end = line[1].split(",").map { value -> value.toInt() }

            val startPos = Point2D(start[0], start[1])
            val endPos = Point2D(end[0], end[1])

            val vents = mappingStrategy.scanLineSegment(startPos, endPos)
            vents.forEach { position -> addVentLocation(position) }
        }
        AdventLogger.info(this)
    }

    fun getDangerousVentCount(): Int {
        return filterTiles { vent -> vent.value >= 2 }.count()
    }

    private fun addVentLocation(pos: Point2D) {
        AdventLogger.debug("Plotting $pos")
        val existing = filterPoints(setOf(pos))
        if (existing.isNotEmpty()) {
            val existingQuantity = existing.values.first().value
            addTile(pos, HydrothermalVent(existingQuantity + 1))
        } else {
            addTile(pos, HydrothermalVent(1))
        }
    }
}
