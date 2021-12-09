package io.github.tomplum.aoc.map

import io.github.tomplum.libs.math.point.Point2D

class SafetyModule(data: List<String>) {

    private val heightMap = HeightMap()

    init {
        var x = 0
        var y = 0
        data.forEach { row ->
            row.forEach { column ->
                heightMap.plotHeight(Point2D(x, y), column.toString().toInt())
                x++
            }
            y++
            x = 0
        }
    }

    fun calculateRiskLevel(): Int {
        return heightMap.getLowPoints().values.sumOf { tile -> tile.height + 1 }
    }
}
