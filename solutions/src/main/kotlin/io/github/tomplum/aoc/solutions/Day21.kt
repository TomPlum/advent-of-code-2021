package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.game.DiracDice
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day21 : Solution<Int, Long> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(21)).value
        val game = DiracDice(input)
        return game.play()
    }

    override fun part2(): Long {
        val input = InputReader.read<String>(Day(21)).value
        val game = DiracDice(input)
        return game.playWithQuantumDice()
    }
}