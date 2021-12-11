package io.github.tomplum.aoc.navigation.depth

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import io.github.tomplum.aoc.navigation.depth.DepthMeter
import io.github.tomplum.aoc.navigation.depth.strategy.ImprovedNavigation
import io.github.tomplum.aoc.navigation.depth.strategy.NaiveNavigation
import org.junit.jupiter.api.Test

class DepthMeterTest {
    @Test
    fun examplePartOne() {
        val course = TestInputReader.read<String>("/day2/example.txt").value
        val report = DepthMeter(course).calculateCourseDestination(NaiveNavigation())
        assertThat(report.getUnifiedValue()).isEqualTo(150)
    }

    @Test
    fun examplePartTwo() {
        val course = TestInputReader.read<String>("/day2/example.txt").value
        val report = DepthMeter(course).calculateCourseDestination(ImprovedNavigation())
        assertThat(report.getUnifiedValue()).isEqualTo(900)
    }
}
