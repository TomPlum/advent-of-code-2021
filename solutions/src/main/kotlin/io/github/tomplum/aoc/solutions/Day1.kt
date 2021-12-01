package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.sonar.SonarScanner
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day1 : Solution<Int, Int> {

    private val report = InputReader.read<Int>(Day(1)).value
    private val scanner = SonarScanner(report)

    override fun part1(): Int {
        return scanner.sweep()
    }

    override fun part2(): Int {
        return scanner.sweepWindowed(3)
    }
}
