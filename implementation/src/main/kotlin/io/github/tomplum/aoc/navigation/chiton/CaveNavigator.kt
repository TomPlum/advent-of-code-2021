package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.point.Point2D
import java.awt.Point
import java.util.*

class CaveNavigator(mapData: List<String>) {

    private val cavern = ChitonCavern()

    init {
/*        var x = 0
        var y = 0
        mapData.forEach { row ->
            row.forEach { column ->
                cavern.addRiskLevel(Point2D(x, y), CavernPosition(column.toString().toInt()))
                x++
            }
            y++
            x = 0
        }*/


        var x = 0
        var y = 0
        val width = mapData.first().length

        mapData.forEach { row ->
            row.forEach { column ->
                val risk = column.toString().toInt()
                (0 until 5).forEach { xTranslate ->
                    (0 until 5).forEach { yTranslate ->
                        val xPos = x + xTranslate * width
                        val yPos = y + yTranslate * width
                        val translateRisk = (risk + xTranslate + yTranslate)
                        val normalisedRisk = if (translateRisk > 9) (translateRisk % 9) else translateRisk
                        cavern.addRiskLevel(Point2D(xPos, yPos), CavernPosition(normalisedRisk))
                    }
                }

                x++
            }
            y++
            x = 0
        }
    }

    fun calculateLowestRiskPath(): Int {
        val origin = Point2D.origin()
        val next: Queue<Point2D> = LinkedList(listOf(origin))
        val shortest = mutableMapOf(origin to 0)

        while (next.isNotEmpty()) {
            val current = next.remove()
            val distanceToCurrent = shortest.getOrDefault(current, 0)

            current.orthogonallyAdjacent()
                .filter { adj -> cavern.hasPosition(adj) }
                .sortedBy { pos -> cavern.getRiskLevel(pos) }
                .forEach { pos ->
                    val newDistance = distanceToCurrent + cavern.getRiskLevel(pos)
                    if (shortest[pos] == null || shortest[pos]!! > newDistance) {
                        shortest[pos] = newDistance
                        next.add(pos)
                    }
                }
        }

        return shortest.values.last()
    }

    fun doThingPartTwo(): Int {
        return 0
    }

   /* fun calculateLowestRiskPath(): Int {
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
    }*/
}
