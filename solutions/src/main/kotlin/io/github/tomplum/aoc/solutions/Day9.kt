package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.map.SafetyModule
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day9 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(9)).value
        val safetyModule = SafetyModule(input)
        return safetyModule.calculateRiskLevel()
    }

    override fun part2(): Int {
        val input = InputReader.read<String>(Day(9)).value
        val safetyModule = SafetyModule(input)
        return safetyModule.getThreeLargestBasinSizes()
    }
}
