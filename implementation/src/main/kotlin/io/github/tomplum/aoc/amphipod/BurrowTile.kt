package io.github.tomplum.aoc.amphipod

import io.github.tomplum.libs.math.map.MapTile

class BurrowTile(override val value: Char): MapTile<Char>(value) {
    fun isFree() = value == '.'

    fun isWall() = value == '#'

    fun isAmphipod() = value in listOf('A', 'B', 'C', 'D')

    fun energyCost() = when(value) {
        'A' -> 1
        'B' -> 10
        'C' -> 100
        'D' -> 1000
        else -> throw IllegalArgumentException("Invalid Amphipod [$this]")
    }
}
