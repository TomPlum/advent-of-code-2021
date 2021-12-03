package io.github.tomplum.aoc.report

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class DiagnosticReportTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day3/example.txt")
        val report = DiagnosticReport(input.value)
        assertThat(report.calculatePowerConsumption()).isEqualTo(198)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("/day3/example.txt")
        val report = DiagnosticReport(input.value)
        assertThat(report.calculateLifeSupportRating()).isEqualTo(230)
    }
}
