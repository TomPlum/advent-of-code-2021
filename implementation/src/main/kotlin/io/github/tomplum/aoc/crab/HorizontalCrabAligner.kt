package io.github.tomplum.aoc.crab

import io.github.tomplum.libs.logging.AdventLogger
import kotlin.math.abs

class HorizontalCrabAligner(private val data: String) {
    fun calculateCheapestFuelCost(): Int {
        val positions = data.trim().split(",").map { value -> value.toInt() }
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

    fun theSecondPart(): Int {
        val positions = data.trim().split(",").map { value -> value.toInt() }.toMutableList()
        val min = positions.distinct().minOrNull()!!
        val max = positions.distinct().maxOrNull()!!
        val posToCheck = (min..max).map { value -> value }
        var cheapest = Integer.MAX_VALUE
        val fuelCost = positions.mapIndexed { i, pos -> (i + 1) to Crab(pos) }.toMap().toMutableMap()
        posToCheck.forEach { targetPos ->
            val cost = positions.fold(0) { total, pos ->
                val cost = getIncrementalFuelCost(1, abs(targetPos - pos))
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

    private fun getIncrementalFuelCost(fuelCost: Int, distance: Int): Int {
        var cost = fuelCost
        var total = 0
        repeat(distance) {
            total += cost
            cost++
        }
        return total
    }
}
