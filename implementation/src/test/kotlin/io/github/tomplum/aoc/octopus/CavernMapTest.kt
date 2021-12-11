package io.github.tomplum.aoc.octopus

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class CavernMapTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day11/example.txt")
        val map = CavernMap(input.value)
        assertThat(map.getTotalFlashesAfterSteps(100)).isEqualTo(1656)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("/day11/example.txt")
        val map = CavernMap(input.value)
        assertThat(map.findSynchronisedFlashStep()).isEqualTo(195)
    }
}

