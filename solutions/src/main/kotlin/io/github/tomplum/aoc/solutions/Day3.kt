package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.report.DiagnosticReport
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day3 : Solution<Int, Int> {

    private val input = InputReader.read<String>(Day(3)).value
    private val diagnosticReport = DiagnosticReport(input)

    override fun part1(): Int {
        return diagnosticReport.calculatePowerConsumption()
    }

    override fun part2(): Int {
        return diagnosticReport.calculateLifeSupportRating()
    }
}
