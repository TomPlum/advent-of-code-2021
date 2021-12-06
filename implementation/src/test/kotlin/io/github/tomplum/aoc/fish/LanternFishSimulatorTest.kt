package io.github.tomplum.aoc.fish

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class LanternFishSimulatorTest {
    @Test
    fun exampleOnePartOne() {
        val input = TestInputReader.read<String>("/day6/example.txt").asSingleString()
        val simulator = LanternFishSimulator(input)
        assertThat(simulator.simulate(18)).isEqualTo(26)
    }

    @Test
    fun exampleTwoPartOne() {
        val input = TestInputReader.read<String>("/day6/example.txt").asSingleString()
        val simulator = LanternFishSimulator(input)
        assertThat(simulator.simulate(80)).isEqualTo(5934)
    }
}
