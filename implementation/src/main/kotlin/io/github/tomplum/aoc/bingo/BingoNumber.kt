package io.github.tomplum.aoc.bingo

import io.github.tomplum.libs.math.map.MapTile

data class BingoNumber(val number: Int) : MapTile<Int>(number) {

    var hasBeenDrawn = false

    fun setHasBeenDrawn() {
        hasBeenDrawn = true
    }

    override fun toString(): String {
        return number.toString()
    }

}
