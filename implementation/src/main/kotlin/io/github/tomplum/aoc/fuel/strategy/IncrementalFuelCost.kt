package io.github.tomplum.aoc.fuel.strategy

import kotlin.math.abs
import kotlin.math.pow

class IncrementalFuelCost : FuelCostStrategy {
    override fun calculateCheapestHorizontalAlignment(positions: List<Int>): Int =
        (positions.minOrNull()!!..positions.maxOrNull()!!).map { value -> value }.minOfOrNull { target ->
            positions.fold(0) { total, pos -> total + abs(target - pos).triangleNumber() }
        } ?: 0

    private fun Int.triangleNumber() = ((this.toDouble().pow(2) + this) / 2).toInt()
}
