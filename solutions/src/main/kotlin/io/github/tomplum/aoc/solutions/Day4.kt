package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.bingo.Bingo
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day4 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(4)).value
        val bingo = Bingo(input)
        return bingo.play()
    }

    override fun part2(): Int {
        val input = InputReader.read<String>(Day(4)).value
        val bingo = Bingo(input)
        return bingo.playUntilLastWinner()
    }
}
