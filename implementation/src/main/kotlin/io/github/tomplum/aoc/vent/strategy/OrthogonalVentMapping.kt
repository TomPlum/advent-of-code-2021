package io.github.tomplum.aoc.vent.strategy

import io.github.tomplum.aoc.vent.VentLine
import io.github.tomplum.libs.math.Direction
import io.github.tomplum.libs.math.point.Point2D

class OrthogonalVentMapping : VentMappingStrategy() {
    override fun scanVentLine(line: VentLine): List<Point2D> {
        val locations = mutableListOf<Point2D>()

        val adjacent = AdjacentVentMapping().scanVentLine(line)

        if (adjacent.isNotEmpty()) {
            locations.addAll(adjacent)
        } else {
            val start = line.getStartPosition()
            val end = line.getEndPosition()

            if (start.x > end.x && start.y > end.y) {
                locations.addAll(getPoints(start, end, Direction.BOTTOM_LEFT))
            } else if (start.x > end.x) {
                locations.addAll(getPoints(start, end, Direction.TOP_LEFT))
            } else if (start.y > end.y) {
                locations.addAll(getPoints(start, end, Direction.BOTTOM_RIGHT))
            } else {
                locations.addAll(getPoints(start, end, Direction.TOP_RIGHT))
            }
        }

        return locations
    }

    private fun getPoints(start: Point2D, end: Point2D, direction: Direction): List<Point2D> {
        val locations = mutableListOf<Point2D>()

        locations.add(start)

        var tracker = start
        while (tracker != end) {
            val next = tracker.shift(direction)
            locations.add(next)
            tracker = next
        }

        return locations
    }

}
