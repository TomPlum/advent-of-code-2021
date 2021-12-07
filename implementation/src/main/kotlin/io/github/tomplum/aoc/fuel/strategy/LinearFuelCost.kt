package io.github.tomplum.aoc.fuel.strategy

import io.github.tomplum.libs.logging.AdventLogger
import kotlin.math.abs

class LinearFuelCost : FuelCostStrategy {
    override fun calculateCheapestHorizontalAlignment(positions: List<Int>): Int {
        var cheapest = Integer.MAX_VALUE
        positions.forEach { target ->
            val cost = positions.fold(0) { total, pos ->
                val cost = abs(target - pos)
                AdventLogger.debug("Move from $target to $pos: $cost fuel")
                total + cost
            }
            if (cost < cheapest) {
                cheapest = cost
            }
        }
        return cheapest
    }
}
