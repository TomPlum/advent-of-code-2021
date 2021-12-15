package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.map.MapTile
import java.util.*

class CavernPosition(val risk: Int) : MapTile<Int>(risk) {
    var shortestPath = LinkedList<CavernPosition>()
    var distance = Int.MAX_VALUE

    fun updateDistance(evaluationNode: CavernPosition, edgeWeight: Int) {
        if (distance + edgeWeight < evaluationNode.distance) {
            evaluationNode.distance = distance + edgeWeight
            val shortestPath = LinkedList(this.shortestPath)
            shortestPath.add(this)
            evaluationNode.shortestPath = shortestPath
        }
    }
}
