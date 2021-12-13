package io.github.tomplum.aoc.camera

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D

class ThermalCamera(data: List<String>) {

    private val instructions = Instructions()
    private val folds = mutableListOf<Pair<Char, Int>>()

    init {
        val coordinates = data.takeWhile { entry -> entry != "" }
        coordinates.forEach { coord ->
            val values = coord.split(",")
            val position = Point2D(values[0].toInt(), values[1].toInt())
            instructions.addDot(position)
        }

        AdventLogger.debug(instructions)

        data.takeLastWhile { line -> line != "" }.forEach { fold ->
            if (fold.contains("y")) {
                folds.add(Pair('y', fold.last().toString().toInt()))
            }

            if (fold.contains("x")) {
                folds.add(Pair('x', fold.last().toString().toInt()))
            }
        }
    }

    fun countVisibleDotsAfterFirstFold(): Int {
        val fold = folds.first()
        if (fold.first == 'x') {
            instructions.xFold(fold.second)
        } else {
            instructions.yFold(fold.second)
        }
        return instructions.getDotCount()
    }

    fun executeAllFolds() {
        folds.forEach { fold ->
            if (fold.first == 'x') {
                instructions.xFold(fold.second)
            } else {
                instructions.yFold(fold.second)
            }
        }
        AdventLogger.debug(instructions)
    }
}
