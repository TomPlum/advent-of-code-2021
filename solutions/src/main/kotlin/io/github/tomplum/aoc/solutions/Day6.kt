package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.fish.LanternFishSimulator
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day6 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(6)).asSingleString()
        val simulator = LanternFishSimulator(input)
        return simulator.simulate(80)
    }
}
