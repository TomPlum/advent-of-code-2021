package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.camera.ThermalCamera
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day13 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(13)).value
        val thermalCamera = ThermalCamera(input)
        return thermalCamera.countVisibleDots()
    }
}