package io.github.tomplum.aoc.camera

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D

class ThermalCamera(data: List<String>) {

    private val instructions = Instructions()
    private val folds = mutableListOf<FoldInstruction>()

    init {
        data.takeWhile { entry -> entry != "" }.forEach { coord ->
            val values = coord.split(",")
            val position = Point2D(values[0].toInt(), values[1].toInt())
            instructions.addDot(position)
        }

        AdventLogger.debug(instructions)

        data.takeLastWhile { line -> line != "" }.forEach { fold ->
            val ordinate = fold.last().toString().toInt()

            if (fold.contains("y")) {
                folds.add(FoldInstruction(FoldAxis.Y, ordinate))
            }

            if (fold.contains("x")) {
                folds.add(FoldInstruction(FoldAxis.X, ordinate))
            }
        }
    }

    fun countVisibleDotsAfterFirstFold(): Int {
        val fold = folds.first()
        instructions.fold(fold)
        return instructions.getDotCount()
    }

    fun executeAllFolds() {
        folds.forEach { fold -> instructions.fold(fold) }
        AdventLogger.debug(instructions)
    }
}
