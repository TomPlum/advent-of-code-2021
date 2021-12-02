package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.DepthMeter
import io.github.tomplum.aoc.navigation.strategy.ImprovedNavigation
import io.github.tomplum.aoc.navigation.strategy.NaiveNavigation
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day2 : Solution<Int, Int> {
    private val course = InputReader.read<String>(Day(2)).value

    override fun part1(): Int {
        val strategy = NaiveNavigation()
        val report = DepthMeter(course).calculateCourseDestination(strategy)
        return report.depth * report.horizontal
    }

    override fun part2(): Int {
        val strategy = ImprovedNavigation()
        val report = DepthMeter(course).calculateCourseDestination(strategy)
        return report.depth * report.horizontal
    }
}
