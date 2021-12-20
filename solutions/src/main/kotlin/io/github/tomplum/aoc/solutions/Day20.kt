package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.map.trench.ImageEnhancer
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day20 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(20)).value
    private val imageEnhancer = ImageEnhancer(input)

    override fun part1(): Int {
        return imageEnhancer.applyEnhancementAlgorithm(2)
    }

    override fun part2(): Int {
        return imageEnhancer.applyEnhancementAlgorithm(50)
    }
}
