package io.github.tomplum.aoc.amphipod

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.point.Point2D
import java.util.*

class AmphipodOrganiser(data: List<String>) {

    private val burrow = AmphipodBurrow()

    private var steps = 0
    private var visited = mutableSetOf<Point2D>()
    private var energyCost = 0

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
        val startingCandidates = burrow.getFirstRoomSpaces()
        startingCandidates.forEach { pos -> search(pos) }
        return 0
    }

    fun search(source: Map.Entry<Point2D, BurrowTile>) {
        val next = Stack<Map.Entry<Point2D, BurrowTile>>()
        visited.add(source.key)
        energyCost += source.value.energyCost()

        val adjacentPositions = source.key.adjacent().filter { pos -> pos !in visited }

        val candidatePositions = adjacentPositions
            .filter { pos -> pos.isInsideHallway() }
            .filter { pos -> pos.isInsideRoom() }
    }

    private fun Point2D.isOutsideRoom(): Boolean = this in listOf(Point2D(3, 1), Point2D(5, 1), Point2D(7, 1), Point2D(9, 1))

    private fun Point2D.isInsideRoom1(): Boolean = this in listOf(Point2D(3, 2), Point2D(3, 3))
    private fun Point2D.isInsideRoom2(): Boolean = this in listOf(Point2D(5, 2), Point2D(5, 3))
    private fun Point2D.isInsideRoom3(): Boolean = this in listOf(Point2D(7, 2), Point2D(7, 3))
    private fun Point2D.isInsideRoom4(): Boolean = this in listOf(Point2D(9, 2), Point2D(9, 3))
    private fun Point2D.isInsideRoom(): Boolean = (this.y == 2 || this.y == 3) && this.x in listOf(3, 5, 7, 9)
    private fun Point2D.isInsideHallway(): Boolean = this.y == 1 && this.x >= 1 && this.x <= 11
}
