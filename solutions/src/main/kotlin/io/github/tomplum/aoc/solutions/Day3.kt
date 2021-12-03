package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.power.PowerConsumption
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day3 : Solution<Int, Int> {

    private val input = InputReader.read<String>(Day(3)).value
    private val powerConsumption = PowerConsumption(input)

    override fun part1(): Int {
        return powerConsumption.doThing()
    }

    override fun part2(): Int {
        return powerConsumption.calculateLifeSupportRating()
    }
}
