package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.map.trench.Scanner
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day20 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(20)).value
        val scanner = Scanner(input)
        return scanner.enhanceImage(2)
    }
}
