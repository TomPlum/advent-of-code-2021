package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.polymer.Polymeriser
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day14 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(14)).value
        val polymeriser = Polymeriser(input)
        return polymeriser.doThing(10) //2604 too high
    }
}
