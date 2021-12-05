package io.github.tomplum.aoc.vent

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import io.github.tomplum.aoc.vent.strategy.AdjacentVentMapping
import io.github.tomplum.aoc.vent.strategy.OrthogonalVentMapping
import org.junit.jupiter.api.Test

class OceanFloorMapTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("day5/example.txt").value
        val map = OceanFloorMap(input, AdjacentVentMapping())
        assertThat(map.getDangerousVentCount()).isEqualTo(5)
    }

    @Test
    fun examplePartTwo() {
        val input = TestInputReader.read<String>("day5/example.txt").value
        val map = OceanFloorMap(input, OrthogonalVentMapping())
        assertThat(map.getDangerousVentCount()).isEqualTo(12)
    }
}
