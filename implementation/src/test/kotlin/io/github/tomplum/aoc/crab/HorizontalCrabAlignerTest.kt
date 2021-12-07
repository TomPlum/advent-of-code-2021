package io.github.tomplum.aoc.crab

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HorizontalCrabAlignerTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day7/example.txt").asSingleString()
        val aligner = HorizontalCrabAligner(input)
        assertThat(aligner.calculateCheapestFuelCost()).isEqualTo(37)
    }
}
