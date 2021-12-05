package io.github.tomplum.aoc.vent

import io.github.tomplum.libs.math.map.MapTile

class HydrothermalVent(override val value: Int) : MapTile<Int>(value) {
    override fun toString(): String {
        return value.toString()
    }
}
