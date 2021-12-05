package io.github.tomplum.aoc.vent.strategy

import io.github.tomplum.libs.math.Direction
import io.github.tomplum.libs.math.point.Point2D

class OrthogonalVentMapping : VentMappingStrategy() {
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
        } else {
            if (start.x > end.x && start.y > end.y) {
                var tracker = start
                locations.add(tracker)
                while (tracker != end) {
                    val next = tracker.shift(Direction.BOTTOM_LEFT)
                    locations.add(next)
                    tracker = next
                }
            } else if (start.x > end.x && start.y < end.y) {
                var tracker = start
                locations.add(tracker)
                while (tracker != end) {
                    val next = tracker.shift(Direction.TOP_LEFT)
                    locations.add(next)
                    tracker = next
                }
            } else if (start.x < end.x && start.y > end.y) {
                var tracker = start
                locations.add(tracker)
                while (tracker != end) {
                    val next = tracker.shift(Direction.BOTTOM_RIGHT)
                    locations.add(next)
                    tracker = next
                }
            } else if (start.x < end.x && start.y < end.y) {
                var tracker = start
                locations.add(tracker)
                while (tracker != end) {
                    val next = tracker.shift(Direction.TOP_RIGHT)
                    locations.add(next)
                    tracker = next
                }
            }
        }

        return locations
    }

}
