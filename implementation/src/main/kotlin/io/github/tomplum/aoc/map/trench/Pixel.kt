package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.math.map.MapTile

class Pixel(override val value: Char) : MapTile<Char>(value) {
    fun isLight() = value == '#'

    fun toBinary(): Char = when(value) {
        '.' -> '0'
        '#' -> '1'
        else -> throw IllegalArgumentException("Invalid Pixel Value [$value]")
    }
}
