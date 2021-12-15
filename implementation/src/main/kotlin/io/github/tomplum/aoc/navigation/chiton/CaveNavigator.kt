package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.point.Point2D

class CaveNavigator(mapData: List<String>) {

    private val cavern = mapData.fold(mutableListOf<Map.Entry<Point2D, CavernPosition>>()) { acc, row ->
        var x = 0
        var y = 0
        row.forEach { column ->
            acc + Point2D(x, y) to CavernPosition(column.toString().toInt())
            x++
        }
        y++
        x = 0
        acc
    }

    fun calculateLowestRiskPath(): Int {
        return 0
    }
}
