package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.vent.OceanFloorMap
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day5 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(5)).value
        val map = OceanFloorMap(input)
        return map.getDangerousVentCount()
    }

    override fun part2(): Int {
        val input = InputReader.read<String>(Day(5)).value
        val map = OceanFloorMap(input)
        return map.getDangerousVentCount()
    }
}
