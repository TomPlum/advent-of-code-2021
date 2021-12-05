package io.github.tomplum.aoc.vent.strategy

import io.github.tomplum.libs.math.point.Point2D

class AdjacentVentMapping : VentMappingStrategy() {
    override fun scanLineSegment(start: Point2D, end: Point2D): Set<Point2D> {
        val locations = mutableSetOf<Point2D>()

        if (start.x == end.x) {
            (start.y.toward(end.y)).forEach { y ->
                locations.add(Point2D(start.x, y))
            }
        } else if (start.y == end.y) {
            (start.x.toward(end.x)).forEach { x ->
                locations.add(Point2D(x, start.y))
            }
        }

        return locations
    }
}
