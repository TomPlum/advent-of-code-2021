package io.github.tomplum.aoc.fuel.strategy

interface FuelCostStrategy {
    fun calculateCheapestHorizontalAlignment(positions: List<Int>): Int
}
