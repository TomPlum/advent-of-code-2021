package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.map.trench.Scanner
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day20 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(20)).value
    private val scanner = Scanner(input)

    override fun part1(): Int {
        return scanner.enhanceImage(2)
    }

    override fun part2(): Int {
        return scanner.enhanceImage(50)
    }
}
