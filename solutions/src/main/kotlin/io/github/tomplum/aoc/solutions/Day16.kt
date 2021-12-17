package io.github.tomplum.aoc.solutions

import io.github.tomplum.aoc.message.PacketDecoder
import io.github.tomplum.libs.input.Day
import io.github.tomplum.libs.input.InputReader
import io.github.tomplum.libs.solutions.Solution

class Day16 : Solution<Int, Int> {
    override fun part1(): Int {
        val input = InputReader.read<String>(Day(16)).asSingleString()
        val decoder = PacketDecoder(input)
        return decoder.calculatePacketVersionNumberSum()
    }
}
