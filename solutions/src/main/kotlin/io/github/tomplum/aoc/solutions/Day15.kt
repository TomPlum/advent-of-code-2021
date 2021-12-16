package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.chiton.CaveNavigator
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day15 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(15)).value
        val navigator = CaveNavigator(input)
        return navigator.calculateLowestRiskPath()
    }
}
