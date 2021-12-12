package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.cave.PathingSystem
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day12 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(12)).value
    private val pathingSystem = PathingSystem(input)

    override fun part1(): Int {
        return pathingSystem.findPathsVisitingSmallCaves()
    }

    override fun part2(): Int {
        return pathingSystem.findPathsVisitingSmallCaveTwice()
    }
}
