package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.point.Point2D
import java.util.*

class CaveNavigator(mapData: List<String>) {

    private val cavern = ChitonCavern()

    init {
        var x = 0
        var y = 0
        mapData.forEach { row ->
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

        val unsettled = PriorityQueue<Node> { a, b -> a.distance - b.distance }
        val settled = mutableListOf<Node>()

        val startNode = Node(start)
        startNode.distance = 0
        unsettled.add(startNode)

        var steps = 0
        while(unsettled.isNotEmpty()) {
            val currentNode = unsettled.poll()
            val adjacentNodes = currentNode?.position?.orthogonallyAdjacent()
                ?.map { pos -> Node(pos) }
                ?.filter { node -> cavern.hasPosition(node.position) }

            adjacentNodes?.forEach { adjacent ->
               if (adjacent !in settled) {
                   val adjacentNodeRiskLevel = cavern.getRiskLevel(adjacent.position)
                   currentNode.updateDistance(adjacent, adjacentNodeRiskLevel)
                   unsettled.add(adjacent)
               }
            }

            settled.add(currentNode)
            steps++
        }

        return (settled.find { it.position == end }
            ?.shortestPath?.map { node -> node.position }
            ?.toSet() ?: emptySet())
            .let { positions -> cavern.calculateTotalRiskLevel(positions) }
    }
}
