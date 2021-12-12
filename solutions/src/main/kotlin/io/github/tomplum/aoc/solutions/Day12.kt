package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.cave.PathingSystem
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day12 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(12)).value
        val pathingSystem = PathingSystem(input)
        return pathingSystem.findPathsVisitingSmallCaves()
    }
}
