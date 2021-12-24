package io.github.tomplum.aoc.amphipod

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class AmphipodOrganiserTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day23/example.txt")
        val organiser = AmphipodOrganiser(input.value)
        assertThat(organiser.organise()).isEqualTo(12521)
    }
}
