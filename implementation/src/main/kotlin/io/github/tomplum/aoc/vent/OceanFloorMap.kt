package io.github.tomplum.aoc.vent

import io.github.tomplum.aoc.vent.strategy.VentMappingStrategy
import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class OceanFloorMap(lines: List<String>, mappingStrategy: VentMappingStrategy) : AdventMap2D<HydrothermalVent>() {
    init {
        lines.map { data -> VentLine(data) }.forEach { line ->
            val vents = mappingStrategy.scanVentLine(line)
            vents.forEach { position -> addVentLocation(position) }
        }
        AdventLogger.info(this)
    }

    fun getDangerousVentCount(): Int {
        return filterTiles { vent -> vent.value >= 2 }.count()
    }

    private fun addVentLocation(pos: Point2D) {
        AdventLogger.debug("Plotting $pos")
        if (hasRecorded(pos)) {
            val existingQuantity = getTile(pos).value
            addTile(pos, HydrothermalVent(existingQuantity + 1))
        } else {
            addTile(pos, HydrothermalVent(1))
        }
    }
}
