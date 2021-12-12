package io.github.tomplum.aoc.navigation.cave

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class PathingSystemTest {
    @Test
    fun exampleOnePartOne() {
        val input = TestInputReader.read<String>("/day12/example-1.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(10)
    }

    @Test
    fun exampleTwoPartOne() {
        val input = TestInputReader.read<String>("/day12/example-2.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(19)
    }

    @Test
    fun exampleThreePartOne() {
        val input = TestInputReader.read<String>("/day12/example-3.txt").value
        val system = PathingSystem(input)
        assertThat(system.findPathsVisitingSmallCaves()).isEqualTo(226)
    }
}
