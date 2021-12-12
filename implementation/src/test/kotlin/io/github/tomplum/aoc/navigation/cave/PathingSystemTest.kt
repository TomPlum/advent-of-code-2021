package io.github.tomplum.aoc.navigation.cave

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class PathingSystemTest {
    @Test
    fun partOneExampleOne() {
        val input = TestInputReader.read<String>("/day12/example-1.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(10)
    }

    @Test
    fun partOneExampleTwo() {
        val input = TestInputReader.read<String>("/day12/example-2.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(19)
    }

    @Test
    fun partOneExampleThree() {
        val input = TestInputReader.read<String>("/day12/example-3.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(226)
    }

    @Test
    fun partTwoExampleOne() {
        val input = TestInputReader.read<String>("/day12/example-1.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaveTwice()).isEqualTo(36)
    }

    @Test
    fun partTwoExampleTwo() {
        val input = TestInputReader.read<String>("/day12/example-2.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaveTwice()).isEqualTo(103)
    }

    @Test
    fun partTwoExampleThree() {
        val input = TestInputReader.read<String>("/day12/example-3.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaveTwice()).isEqualTo(3509)
    }
}
