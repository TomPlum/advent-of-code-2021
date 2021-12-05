package io.github.tomplum.aoc.vent

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class OceanFloorMapTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("day5/example.txt").value
        val map = OceanFloorMap(input)
        assertThat(map.getDangerousVentCount()).isEqualTo(5)
    }
}
