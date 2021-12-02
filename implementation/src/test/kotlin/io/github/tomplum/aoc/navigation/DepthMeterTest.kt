package io.github.tomplum.aoc.navigation

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class DepthMeterTest {
    @Test
    fun exampleOne() {
        val course = TestInputReader.read<String>("/day2/example.txt").value
        val report = DepthMeter(course).calculateCourseDestination()
        assertThat(report.depth * report.horizontal).isEqualTo(150)
    }
}
