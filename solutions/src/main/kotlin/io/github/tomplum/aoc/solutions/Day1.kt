package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.sonar.SonarScanner
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day1 : Solution<Int, String> {
    override fun part1(): Int {
        val report = InputReader.read<Int>(Day(1)).value
        val scanner = SonarScanner(report)
        return scanner.sweep()
    }
}
