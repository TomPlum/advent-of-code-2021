package io.github.tomplum.aoc.camera

import io.github.tomplum.libs.math.map.MapTile

class PaperSegment(override val value: Char) : MapTile<Char>(value) {
    fun hasDot(): Boolean {
        return value == '#'
    }
}
