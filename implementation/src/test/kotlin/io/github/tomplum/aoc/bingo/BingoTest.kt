package io.github.tomplum.aoc.bingo

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class BingoTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("day4/example.txt").value
        val bingo = Bingo(input)
        assertThat(bingo.playUntilFirstWinner()).isEqualTo(4512)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("day4/example.txt").value
        val bingo = Bingo(input)
        assertThat(bingo.playUntilLastWinner()).isEqualTo(1924)
    }
}
