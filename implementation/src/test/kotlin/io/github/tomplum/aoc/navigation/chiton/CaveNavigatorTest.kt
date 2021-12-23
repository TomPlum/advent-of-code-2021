package io.github.tomplum.aoc.navigation.chiton

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import io.github.tomplum.aoc.navigation.chiton.strategy.LargeCaveGeneration
import io.github.tomplum.aoc.navigation.chiton.strategy.SmallCaveGeneration
import org.junit.jupiter.api.Test

class CaveNavigatorTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day15/example.txt").value
        val navigator = CaveNavigator(input, SmallCaveGeneration())
        assertThat(navigator.calculateLowestRiskPath()).isEqualTo(40)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day15/example.txt").value
        val navigator = CaveNavigator(input, LargeCaveGeneration())
        assertThat(navigator.calculateLowestRiskPath()).isEqualTo(315)
    }
}
