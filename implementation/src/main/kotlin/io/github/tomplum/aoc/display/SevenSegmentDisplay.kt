package io.github.tomplum.aoc.display

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class SevenSegmentDisplay : AdventMap2D<DisplayPixel>() {
    init {
        (0..6).forEach { y ->
            (0..5).forEach { x ->
                addTile(Point2D(x, y), DisplayPixel(' '))
            }
        }
    }

    fun setSegmentA(value: Char) {
        (1..4).forEach { x ->
            addTile(Point2D(x, 0), DisplayPixel(value))
        }
    }

    fun setSegmentB(value: Char) {
        addTile(Point2D(0, 1), DisplayPixel(value))
        addTile(Point2D(0, 2), DisplayPixel(value))
    }

    fun setSegmentC(value: Char) {
        addTile(Point2D(5, 1), DisplayPixel(value))
        addTile(Point2D(5, 2), DisplayPixel(value))
    }

    fun setSegmentD(value: Char) {
        (1..4).forEach { x ->
            addTile(Point2D(x, 3), DisplayPixel(value))
        }
    }

    fun setSegmentE(value: Char) {
        addTile(Point2D(0, 4), DisplayPixel(value))
        addTile(Point2D(0, 5), DisplayPixel(value))
    }

    fun setSegmentF(value: Char) {
        addTile(Point2D(5, 4), DisplayPixel(value))
        addTile(Point2D(5, 5), DisplayPixel(value))
    }

    fun setSegmentG(value: Char) {
        (1..4).forEach { x ->
            addTile(Point2D(x, 6), DisplayPixel(value))
        }
    }
}
