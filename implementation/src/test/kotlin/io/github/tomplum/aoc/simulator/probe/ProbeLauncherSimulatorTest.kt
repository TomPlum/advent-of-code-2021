package io.github.tomplum.aoc.simulator.probe

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import io.github.tomplum.libs.math.point.Point2D
import org.junit.jupiter.api.Test

class ProbeLauncherSimulatorTest {
    @Test
    fun exampleOne() {
        val input = TestInputReader.read<String>("/day17/example.txt").asSingleString()
        val simulator = ProbeLauncherSimulator(input)
        assertThat(simulator.calculateMaximumVerticalHeight()).isEqualTo(45)
    }

    @Test
    fun exampleTwo() {
        val ordinates = TestInputReader.read<String>("/day17/test.txt").value.flatMap { line ->
            line.split("@").map { pair -> pair.split(",").let { values -> Point2D(values[0].toInt(), values[1].toInt()) } }
        }
        val input = TestInputReader.read<String>("/day17/example.txt").asSingleString()
        val simulator = ProbeLauncherSimulator(input)
        val validPoints = simulator.calculateTotalDistinctInitialVelocityValues()
        val diff = ordinates.minus(validPoints)
        val s = ""
        assertThat(validPoints.size).isEqualTo(112)
    }
}
