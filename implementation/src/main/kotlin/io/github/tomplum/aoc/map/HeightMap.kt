package io.github.tomplum.aoc.map

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class HeightMap : AdventMap2D<HeightMapTile>() {
    fun plotHeight(pos: Point2D, height: Int) {
        addTile(pos, HeightMapTile(height))
    }

    fun getLowPoints(): Map<Point2D, HeightMapTile> = getDataMap().filter { (pos, tile) ->
        filterPoints(pos.adjacent().toSet()).all { adjacent -> adjacent.value.height > tile.height }
    }
}
