package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.crab.HorizontalCrabAligner
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day7 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(7)).asSingleString()
        val aligner = HorizontalCrabAligner(input)
        return aligner.calculateCheapestFuelCost()
    }
}
