package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.bingo.Bingo
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day4 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(4)).value
    private val bingo = Bingo(input)

    override fun part1(): Int {
        return bingo.playUntilFirstWinner()
    }

    override fun part2(): Int {
        return bingo.playUntilLastWinner()
    }
}
