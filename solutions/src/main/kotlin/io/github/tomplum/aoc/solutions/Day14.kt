package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.polymer.Polymeriser
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day14 : Solution<Long, Long> {
    override fun part1(): Long {
        val input = InputReader.read<String>(Day(14)).value
        val polymeriser = Polymeriser(input)
        return polymeriser.doThing(10)
    }

    override fun part2(): Long {
        val input = InputReader.read<String>(Day(14)).value
        val polymeriser = Polymeriser(input)
        return polymeriser.doThing(40)
    }
}
