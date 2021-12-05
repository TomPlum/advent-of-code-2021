package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.vent.OceanFloorMap
import io.github.tomplum.aoc.vent.strategy.AdjacentVentMapping
import io.github.tomplum.aoc.vent.strategy.OrthogonalVentMapping
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day5 : Solution<Int, Int> {
    private val input = InputReader.read<String>(Day(5)).value

    override fun part1(): Int {
        val map = OceanFloorMap(input, AdjacentVentMapping())
        return map.getDangerousVentCount()
    }

    override fun part2(): Int {
        val map = OceanFloorMap(input, OrthogonalVentMapping())
        return map.getDangerousVentCount()
    }
}
