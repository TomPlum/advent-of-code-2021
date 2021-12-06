package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.fish.LanternFishSimulator
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day6 : Solution<Long, Long> {
    override fun part1(): Long {
        val input = InputReader.read<String>(Day(6)).asSingleString()
        val simulator = LanternFishSimulator(input)
        return simulator.simulate(80)
    }

    override fun part2(): Long {
        val input = InputReader.read<String>(Day(6)).asSingleString()
        val simulator = LanternFishSimulator(input)
        return simulator.simulate(256)
    }
}
