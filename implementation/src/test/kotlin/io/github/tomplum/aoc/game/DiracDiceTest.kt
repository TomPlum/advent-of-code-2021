package io.github.tomplum.aoc.game

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class DiracDiceTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day21/example.txt").value
        val game = DiracDice(input)
        assertThat(game.play()).isEqualTo(739785)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day21/example.txt").value
        val game = DiracDice(input)
        assertThat(game.playWithQuantumDice()).isEqualTo(444356092776315L)
    }
}
