package io.github.tomplum.aoc.amphipod

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D

class AmphipodOrganiser(data: List<String>) {

    private val burrow = AmphipodBurrow()

    init {
        var x = 0
        var y = 0
        data.forEach { row ->
            row.forEach { column ->
                burrow.addBurrowTile(Point2D(x, y), BurrowTile(column))
                x++
            }
            y++
            x = 0
        }
        AdventLogger.debug("Starting Configuration")
        AdventLogger.debug(burrow)
    }

    fun organise(): Int {
        val energy = mutableMapOf<Char, Int>()
        val roomOneToMove =
        return 0
    }

    private fun Point2D.isOutsideRoom(): Boolean = this in listOf(Point2D(3, 1), Point2D(5, 1), Point2D(7, 1), Point2D(9, 1))

    private fun Point2D.isInsideRoom1(): Boolean = this in listOf(Point2D(3, 2), Point2D(3, 3))
    private fun Point2D.isInsideRoom2(): Boolean = this in listOf(Point2D(5, 2), Point2D(5, 3))
    private fun Point2D.isInsideRoom3(): Boolean = this in listOf(Point2D(7, 2), Point2D(7, 3))
    private fun Point2D.isInsideRoom4(): Boolean = this in listOf(Point2D(9, 2), Point2D(9, 3))
    private fun Point2D.isInsideHallway(): Boolean = this.y == 1 && this.x >= 1 && this.x <= 11

    private fun Char.energyUsed() = when(this) {
        'A' -> 1
        'B' -> 10
        'C' -> 100
        'D' -> 1000
        else -> throw IllegalArgumentException("Invalid Amphipod [$this]")
    }
}
