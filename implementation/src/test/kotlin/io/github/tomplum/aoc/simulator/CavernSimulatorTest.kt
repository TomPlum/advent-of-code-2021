package io.github.tomplum.aoc.simulator

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class CavernSimulatorTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day11/example.txt")
        val map = CavernSimulator(input.value)
        assertThat(map.getTotalFlashesAfterSteps(100)).isEqualTo(1656)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("/day11/example.txt")
        val map = CavernSimulator(input.value)
        assertThat(map.findSynchronisedFlashStep()).isEqualTo(195)
    }
}

