package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.navigation.subsystem.NavigationSubsystem
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day10 : Solution<Int, Long> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(10)).value
        val subsystem = NavigationSubsystem(input)
        return subsystem.getTotalSyntaxErrorScore()
    }

    override fun part2(): Long {
        val input = InputReader.read<String>(Day(10)).value
        val subsystem = NavigationSubsystem(input)
        return subsystem.getMiddlingAutoCompleteScore()
    }
}
