package io.github.tomplum.aoc.vent

import io.github.tomplum.libs.math.point.Point2D

data class VentLine(private val data: String) {
    fun getStartPosition(): Point2D {
        val line = data.split(" -> ")
        val start = line[0].split(",").map { value -> value.toInt() }
        return Point2D(start[0], start[1])
    }

    fun getEndPosition(): Point2D {
        val line = data.split(" -> ")
        val end = line[1].split(",").map { value -> value.toInt() }
        return Point2D(end[0], end[1])
    }
}
