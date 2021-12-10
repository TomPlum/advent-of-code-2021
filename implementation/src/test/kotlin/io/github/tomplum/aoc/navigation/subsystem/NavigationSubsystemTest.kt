package io.github.tomplum.aoc.navigation.subsystem

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class NavigationSubsystemTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day10/example.txt").value
        val subsystem = NavigationSubsystem(input)
        assertThat(subsystem.getTotalSyntaxErrorScore()).isEqualTo(26397)
    }
}
