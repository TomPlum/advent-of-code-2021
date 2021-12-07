package io.github.tomplum.aoc.fuel.strategy

import io.github.tomplum.libs.logging.AdventLogger
import kotlin.math.abs

class IncrementalFuelCost : FuelCostStrategy {
    override fun calculateCheapestHorizontalAlignment(positions: List<Int>): Int {
        val posToCheck = (positions.minOrNull()!!..positions.maxOrNull()!!).map { value -> value }
        var cheapest = Integer.MAX_VALUE
        posToCheck.forEach { targetPos ->
            val cost = positions.fold(0) { total, pos ->
                val cost = getIncrementalFuelCost(abs(targetPos - pos))
                AdventLogger.debug("Move from $targetPos to $pos: $cost fuel")
                total + cost
            }
            AdventLogger.debug("[Total cost: $cost]\n")
            if (cost < cheapest) {
                cheapest = cost
            }
        }
        AdventLogger.debug("[Cheapest cost: $cheapest]\n")
        return cheapest
    }

    private fun getIncrementalFuelCost(distance: Int): Int {
        var cost = 1
        var total = 0
        repeat(distance) {
            total += cost
            cost++
        }
        return total
    }
}
