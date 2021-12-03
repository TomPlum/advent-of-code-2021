package io.github.tomplum.aoc.power

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PowerConsumptionTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day3/example.txt")
        val powerConsumption = PowerConsumption(input.value)
        assertThat(powerConsumption.doThing()).isEqualTo(198)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("/day3/example.txt")
        val powerConsumption = PowerConsumption(input.value)
        assertThat(powerConsumption.calculateLifeSupportRating()).isEqualTo(230)
    }
}
