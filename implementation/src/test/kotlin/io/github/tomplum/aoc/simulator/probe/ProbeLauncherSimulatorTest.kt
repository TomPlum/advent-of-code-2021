package io.github.tomplum.aoc.simulator.probe

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class ProbeLauncherSimulatorTest {
    @Test
    fun exampleOne() {
        val input = TestInputReader.read<String>("/day17/example.txt").asSingleString()
        val simulator = ProbeLauncherSimulator(input)
        assertThat(simulator.calculateMaximumVerticalHeight()).isEqualTo(45)
    }
}
