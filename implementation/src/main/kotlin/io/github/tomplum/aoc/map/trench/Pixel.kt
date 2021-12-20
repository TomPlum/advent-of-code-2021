package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.math.map.MapTile

class Pixel(override val value: Char) : MapTile<Char>(value) {
    fun isLight() = value == '#'

    fun isDark() = value == '.'

    fun toBinary(step: Int): Char = when(value) {
        '.' -> '0' //if (step % 2 == 0) '1' else '0'
        '#' -> '1'
        else -> throw IllegalArgumentException("Invalid Pixel Value [$value]")
    }
}
