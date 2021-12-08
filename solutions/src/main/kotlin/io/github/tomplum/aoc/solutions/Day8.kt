package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.display.DisplayAnalyser
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day8 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(8)).value
        val analyser = DisplayAnalyser(input)
        return analyser.countUniqueSegmentsInstances()
    }

    override fun part2(): Int {
        val input = InputReader.read<String>(Day(8)).value
        val analyser = DisplayAnalyser(input)
        return analyser.getOutputValueSum()
    }
}
