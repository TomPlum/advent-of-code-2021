package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.depth.DepthMeter
import io.github.tomplum.aoc.navigation.depth.strategy.ImprovedNavigation
import io.github.tomplum.aoc.navigation.depth.strategy.NaiveNavigation
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day2 : Solution<Int, Int> {
    private val course = InputReader.read<String>(Day(2)).value
    private val depthMeter = DepthMeter(course)

    override fun part1(): Int {
        val strategy = NaiveNavigation()
        val report = depthMeter.calculateCourseDestination(strategy)
        return report.getUnifiedValue()
    }

    override fun part2(): Int {
        val strategy = ImprovedNavigation()
        val report = depthMeter.calculateCourseDestination(strategy)
        return report.getUnifiedValue()
    }
}
