package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class ChitonCavern : AdventMap2D<CavernPosition>() {
    fun addRiskLevel(pos: Point2D, position: CavernPosition) {
        addTile(pos, position)
    }

    fun getRiskLevel(pos: Point2D): Int {
        return getTile(pos).risk
    }

    fun getCavernPosition(point: Point2D) = getTile(point)

    fun getCavernPositions(points: List<Point2D>) = filterPoints(points.toSet())

    fun getPositions() = getDataMap().keys

    fun getBottomRightMostPoint(): Point2D {
        return Point2D(xMax()!!, yMax()!!)
    }
}
