package io.github.tomplum.aoc.vent.strategy

import io.github.tomplum.libs.math.point.Point2D

abstract class VentMappingStrategy {
    abstract fun scanLineSegment(start: Point2D, end: Point2D): Set<Point2D>

    protected infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }
}
