package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.fuel.HorizontalCrabAligner
import io.github.tomplum.aoc.fuel.strategy.IncrementalFuelCost
import io.github.tomplum.aoc.fuel.strategy.LinearFuelCost
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day7 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(7)).asSingleString()
    private val aligner = HorizontalCrabAligner(input)

    override fun part1(): Int {
        val strategy = LinearFuelCost()
        return aligner.calculateCheapestFuelCost(strategy)
    }

    override fun part2(): Int {
        val strategy = IncrementalFuelCost()
        return aligner.calculateCheapestFuelCost(strategy)
    }
}
