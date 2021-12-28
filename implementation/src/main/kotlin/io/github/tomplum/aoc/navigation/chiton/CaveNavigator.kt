package io.github.tomplum.aoc.navigation.chiton

import io.github.tomplum.aoc.navigation.chiton.strategy.CaveGenerationStrategy
import io.github.tomplum.libs.math.point.Point2D
import java.util.*

class CaveNavigator(data: List<String>, strategy: CaveGenerationStrategy) {

    private val cavern = strategy.generate(data)

    fun calculateLowestRiskPath(): Int {
        val origin = Point2D.origin()
        val next: Queue<Point2D> = LinkedList(listOf(origin))
        val shortest = mutableMapOf(origin to 0)
        val map = cavern.getDataMap().map { it.key to it.value.risk }.toMap()

        while (next.isNotEmpty()) {
            val current = next.remove()
            val distanceToCurrent = shortest[current]!!

            current.orthogonallyAdjacent()
                .filter { pos -> map[pos] != null }
                .sortedBy { pos -> map[pos] }
                .forEach { pos ->
                    val newDistance = distanceToCurrent + map[pos]!!
                    if (shortest[pos] == null || shortest[pos]!! > newDistance) {
                        shortest[pos] = newDistance
                        next.add(pos)
                    }
                }
        }

        return shortest.values.last()
    }
}
