package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.libs.math.point.Point2D
import java.util.*

data class Node(val position: Point2D) {
    var shortestPath = LinkedList<Node>()
    var distance = 2000000000

    fun updateDistance(evaluationNode: Node, edgeWeight: Int) {
        if (distance + edgeWeight < evaluationNode.distance) {
            evaluationNode.distance = distance + edgeWeight
            val shortestPath = LinkedList(this.shortestPath)
            shortestPath.add(this)
            evaluationNode.shortestPath = shortestPath
        }
    }
}
