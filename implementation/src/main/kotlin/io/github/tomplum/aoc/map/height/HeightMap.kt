package io.github.tomplum.aoc.map.height

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class HeightMap : AdventMap2D<HeightMapTile>() {
    fun plotHeight(pos: Point2D, height: Int) {
        addTile(pos, HeightMapTile(height))
    }

    fun getLowPoints(): Map<Point2D, HeightMapTile> = getDataMap()
        .filterValues { tile -> tile.height < 9 }
        .filter { (pos, tile) ->
            filterPoints(pos.adjacent().toSet()).all { adjacent -> adjacent.value.height > tile.height }
        }

    fun getBasins(): List<Map<Point2D, HeightMapTile>> = getLowPoints().map { (pos, tile) ->
        val positions = mutableListOf(pos)
        val next = mutableListOf<Point2D>()
        next.addAll(pos.orthogonallyAdjacent())

        while (next.isNotEmpty()) {
            val matching = filterPoints(next.toSet()).filter { adjacent -> adjacent.value.height < 9 }
            next.clear()
            positions.addAll(matching.keys)
            val upNext = matching.keys.flatMap { matched -> matched.orthogonallyAdjacent() }.filter { it !in positions }
            next.addAll(upNext)
        }

        filterPoints(positions.toSet())
    }
}
