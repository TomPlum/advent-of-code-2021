package io.github.tomplum.aoc.fuel.strategy

import io.github.tomplum.libs.extensions.nthBinomialCoefficient
import kotlin.math.abs

class IncrementalFuelCost : FuelCostStrategy {
    override fun calculateCheapestHorizontalAlignment(positions: List<Int>): Int =
        (positions.minOrNull()!!..positions.maxOrNull()!!).map { value -> value }.minOfOrNull { target ->
            positions.fold(0) { total, pos -> total + abs(target - pos).nthBinomialCoefficient() }
        } ?: 0
}
