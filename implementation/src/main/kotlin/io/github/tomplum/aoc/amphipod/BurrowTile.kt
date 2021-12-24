package io.github.tomplum.aoc.amphipod

import io.github.tomplum.libs.math.map.MapTile

class BurrowTile(override val value: Char): MapTile<Char>(value) {
    fun isFree() = value == '.'

    fun isWall() = value == '#'

    fun isAmphipod() = value in listOf('A', 'B', 'C', 'D')
}
