package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.point.Point2D
import java.util.*

class CaveNavigator(mapData: List<String>) {

    private val cavern = ChitonCavern()

    init {
        mapData.forEach { row ->
            var x = 0
            var y = 0
            row.forEach { column ->
                cavern.addRiskLevel(Point2D(x, y), CavernPosition(column.toString().toInt()))
                x++
            }
            y++
            x = 0
        }
    }

    fun calculateLowestRiskPath(): Int {
        val start = Point2D(0, 0)
        val end = cavern.getBottomRightMostPoint()

        val weighting = cavern.getPositions().associateWith { Int.MAX_VALUE }.toMutableMap()
        val graph = mutableSetOf<Pair<Point2D, CavernPosition>>()
        val unsettled = PriorityQueue<Pair<Point2D, CavernPosition>> { a, b -> a.second.distance - b.second.distance }
        var steps = 0
        while(unsettled.isNotEmpty()) {
            val current = unsettled.poll()
            if (current.first == end) {
                return current.second.shortestPath.sumOf { pos -> pos.risk }
            }
            val node = graph.find { node -> node.first == current.first }
            val adjacent = node?.first?.adjacent()?.filter { point -> point !in unsettled.map { node -> node.first } }
            cavern.getCavernPositions(adjacent!!).forEach { (pos, adjacent) ->
                adjacent.updateDistance(adjacent, adjacent.risk)
                unsettled.add(Pair(pos, adjacent))
            }
            steps++
        }

        return 0
    }
}
