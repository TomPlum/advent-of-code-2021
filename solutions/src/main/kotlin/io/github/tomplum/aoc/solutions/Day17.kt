package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.simulator.probe.ProbeLauncherSimulator
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day17 : Solution<Int, Int> {

    private val input = InputReader.read<String>(Day(17)).asSingleString()
    private val simulator = ProbeLauncherSimulator(input)

    override fun part1(): Int {
        return simulator.calculateMaximumVerticalHeight()
    }

    override fun part2(): Int {
        return simulator.calculateTotalDistinctInitialVelocityValues()
    }
}
