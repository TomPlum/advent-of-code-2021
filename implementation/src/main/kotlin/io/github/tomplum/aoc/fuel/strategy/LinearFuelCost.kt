package io.github.tomplum.aoc.fuel.strategy

import kotlin.math.abs

class LinearFuelCost : FuelCostStrategy {
    override fun calculateCheapestHorizontalAlignment(positions: List<Int>) = positions.minOfOrNull { target ->
        positions.fold(0) { total, pos -> total + abs(target - pos) }
    } ?: 0
}
