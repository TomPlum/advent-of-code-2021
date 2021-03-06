package io.github.tomplum.aoc.map.height

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import io.github.tomplum.aoc.map.height.SafetyModule
import org.junit.jupiter.api.Test

class SafetyModuleTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day9/example.txt").value
        val safetyModule = SafetyModule(input)
        assertThat(safetyModule.calculateRiskLevel()).isEqualTo(15)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day9/example.txt").value
        val safetyModule = SafetyModule(input)
        assertThat(safetyModule.getThreeLargestBasinSizes()).isEqualTo(1134)
    }
}
