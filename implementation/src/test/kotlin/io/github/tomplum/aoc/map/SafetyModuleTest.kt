package io.github.tomplum.aoc.map

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class SafetyModuleTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day9/example.txt").value
        val safetyModule = SafetyModule(input)
        assertThat(safetyModule.calculateRiskLevel()).isEqualTo(15)
    }
}
