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
        val graph = cavern.getGraphRepresentation()

        val unsettled = PriorityQueue<Node> { a, b -> a.distance - b.distance }
        val settled = hashSetOf<Node>()

        val root = graph[Point2D(0, 0)]
        root?.distance = 0
        unsettled.add(root)

        while(unsettled.isNotEmpty()) {
            val currentNode = unsettled.poll()
            val adjacentNodes = currentNode.adjacentNodes
            adjacentNodes.forEach { (adjacent, edgeWeight) ->
               if (adjacent !in settled) {
                   currentNode.updateDistance(adjacent, edgeWeight)
                   unsettled.add(adjacent)
               }
            }

            settled.add(currentNode)
        }
        //348 too low
        return graph[cavern.getBottomRightMostPoint()]?.distance ?: 0
    }
}
