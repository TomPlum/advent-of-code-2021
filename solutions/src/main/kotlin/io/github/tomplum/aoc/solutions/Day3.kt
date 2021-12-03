package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.power.PowerConsumption
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day3 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(3)).value
        val powerConsumption = PowerConsumption(input)
        return powerConsumption.doThing()
    }
}
