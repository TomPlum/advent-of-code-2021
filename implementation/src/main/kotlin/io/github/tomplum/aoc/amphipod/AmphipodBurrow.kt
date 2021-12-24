package io.github.tomplum.aoc.amphipod

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class AmphipodBurrow : AdventMap2D<BurrowTile>() {
    fun addBurrowTile(pos: Point2D, tile: BurrowTile) = addTile(pos, tile)

    fun isRoomFree(room: Char) = when(room) {
        'A' -> getTile(Point2D(3, 2)).isFree() || getTile(Point2D(3, 3)).isFree()
        'B' -> getTile(Point2D(5, 2)).isFree() || getTile(Point2D(5, 3)).isFree()
        'C' -> getTile(Point2D(7, 2)).isFree() || getTile(Point2D(7, 3)).isFree()
        'D' -> getTile(Point2D(9, 2)).isFree() || getTile(Point2D(9, 3)).isFree()
        else -> throw IllegalArgumentException("Invalid Room ID [$room]")
    }

    fun getFirstRoomSpaces() = filterPoints(setOf(Point2D(3,2), Point2D(5,2), Point2D(7,2), Point2D(9,2)))
}
