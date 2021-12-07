package io.github.tomplum.aoc.fuel

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.fuel.strategy.IncrementalFuelCost
import io.github.tomplum.aoc.fuel.strategy.LinearFuelCost
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class HorizontalCrabAlignerTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day7/example.txt").asSingleString()
        val aligner = HorizontalCrabAligner(input)
        assertThat(aligner.calculateCheapestFuelCost(LinearFuelCost())).isEqualTo(37)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("/day7/example.txt").asSingleString()
        val aligner = HorizontalCrabAligner(input)
        assertThat(aligner.calculateCheapestFuelCost(IncrementalFuelCost())).isEqualTo(168)
    }
}
