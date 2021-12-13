package io.github.tomplum.aoc.camera

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D

class ThermalCamera(data: List<String>) {

    private val instructions = Instructions()

    init {
        val coordinates = data.takeWhile { entry -> entry != "" }
        coordinates.forEach { coord ->
            val values = coord.split(",")
            val position = Point2D(values[0].toInt(), values[1].toInt())
            instructions.addDot(position)
        }

        AdventLogger.debug(instructions)

        val folds = data.takeLastWhile { line -> line != "" }
        folds.take(1).forEach { fold ->
            if (fold.contains("y")) {
                instructions.yFold(fold.last().toString().toInt())
                AdventLogger.debug(instructions)
            }

            if (fold.contains("x")) {
                instructions.xFold(fold.last().toString().toInt())
                AdventLogger.debug(instructions)
            }
        }
    }

    fun countVisibleDots(): Int {
        return instructions.getDotCount()
    }
}
