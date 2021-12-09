package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.map.SafetyModule
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day9 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(9)).value
    private val safetyModule = SafetyModule(input)

    override fun part1(): Int {
        return safetyModule.calculateRiskLevel()
    }

    override fun part2(): Int {
        return safetyModule.getThreeLargestBasinSizes()
    }
}
