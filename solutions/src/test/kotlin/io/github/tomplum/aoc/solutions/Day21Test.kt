package io.github.tomplum.aoc.solutions

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day21Test {
    private val solution = Day21()

    @Test
    fun partOne() {
        assertThat(solution.part1()).isEqualTo(551901)
    }

    @Test
    fun partTwo() {
        assertThat(solution.part2()).isEqualTo(272847859601291L)
    }
}
