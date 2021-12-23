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

    fun getGraphRepresentation(): Map<Point2D, Node> {
        val nodes = getDataMap().entries.associate { (pos, value) -> pos to Node(pos, value.risk) }
        getDataMap().keys.forEach { pos ->
            val node = nodes[pos]
            val adjacent = filterPoints(pos.orthogonallyAdjacent().toSet())
            adjacent.forEach { (adjacentPos, adjacentValue) ->
                val found = nodes[adjacentPos]!!
                node?.addDestination(found, adjacentValue.risk)
            }
        }
        return nodes
    }

    fun getCavernPosition(point: Point2D) = getTile(point)

    fun getCavernPositions(points: List<Point2D>) = filterPoints(points.toSet())

    fun getPositions() = getDataMap().keys

    fun getBottomRightMostPoint(): Point2D {
        return Point2D(xMax()!!, yMax()!!)
    }

    fun hasPosition(pos: Point2D): Boolean {
        return hasRecorded(pos)
    }

    fun calculateTotalRiskLevel(points: Set<Point2D>): Int {
        return filterPoints(points).values.sumOf { position -> position.risk }
    }

    /*fun discoverRemainingCavernLocations() {
        val width = xMax()!!
        val targetMax = width * 5
        var originalSquare = getDataMap()
        while(xMax()!! < targetMax) {
            val xMax = xMax()!!
            val yMax = yMax()!!
            if (xMax < targetMax) {
                val xRange = (xMax - width)..xMax
                xRange.forEachIndexed { i, x ->
                    val updatedPosition = Point2D(x, pos.y)
                    val updatedRisk = if (tile.risk == 9) 0 else tile.risk + 1
                }
            }

            var rightSquare = originalSquare.map { (pos, tile) ->
                val updatedPosition = Point2D(pos.x + 1, pos.y)
                val updatedRisk = if (tile.risk == 9) 0 else tile.risk + 1
                updatedPosition to CavernPosition(updatedRisk)
            }

            rightSquare.forEach { (pos, risk) -> addTile(pos, risk) }
        }
    }*/
}
