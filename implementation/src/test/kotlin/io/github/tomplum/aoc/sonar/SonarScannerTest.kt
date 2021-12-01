package io.github.tomplum.aoc.sonar

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class SonarScannerTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<Int>("/day1/example.txt").value
        val scanner = SonarScanner(input)
        assertThat(scanner.sweep()).isEqualTo(7)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<Int>("/day1/example.txt").value
        val scanner = SonarScanner(input)
        assertThat(scanner.sweepWindowed(3)).isEqualTo(5)
    }
}
