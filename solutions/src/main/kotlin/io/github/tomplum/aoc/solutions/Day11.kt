package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.octopus.CavernMap
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day11 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(11)).value
        val cavernMap = CavernMap(input)
        return cavernMap.getTotalFlashesAfterSteps(100)
    }
}
