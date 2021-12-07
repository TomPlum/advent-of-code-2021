package io.github.tomplum.aoc.fuel

import io.github.tomplum.aoc.fuel.strategy.FuelCostStrategy

class HorizontalCrabAligner(private val data: String) {
    fun calculateCheapestFuelCost(strategy: FuelCostStrategy): Int {
        val positions = data.trim().split(",").map { value -> value.toInt() }
        return strategy.calculateCheapestHorizontalAlignment(positions)
    }
}
