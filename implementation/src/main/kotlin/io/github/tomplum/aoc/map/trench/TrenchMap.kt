package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.logging.AdventLogger
import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class TrenchMap(data: List<String>) : AdventMap2D<Pixel>() {

    init {
        var x = 0
        var y = 0
        data.takeLastWhile { line -> line != "" }.forEach { row ->
            row.forEach { column ->
                addTile(Point2D(x, y), Pixel(column))
                x++
            }
            y++
            x = 0
        }

        AdventLogger.debug(this)
    }

    fun getPixels() = getDataMap()

    fun getSurroundingPixelSquare(position: Point2D): List<Pixel> {
        val x = position.x
        val y = position.y

        return listOf(
            Point2D(x - 1, y - 1), Point2D(x, y - 1), Point2D(x + 1, y - 1),
            Point2D(x - 1, y), position, Point2D(x + 1, y),
            Point2D(x - 1, y + 1), Point2D(x, y + 1), Point2D(x + 1, y + 1)
        ).associateWith { pos -> getTile(pos, Pixel('?')) }.values.toList()
    }

    fun updatePixel(position: Point2D, pixel: Pixel) {
        addTile(position, pixel)
    }

    fun countIlluminatedPixels(): Int = filterTiles { pixel -> pixel.isLight() }.count()

    fun addNewSurroundingCells(quantity: Int) {
        val pixel = Pixel('?')

        repeat(quantity) {
            val xMax = xMax()!!
            val xMin = xMin()!!
            val yMax = yMax()!!
            val yMin = yMin()!!

            (yMin - 1..yMax + 1).forEach { y ->
                addTile(Point2D(xMin - 1, y), pixel)
                addTile(Point2D(xMax + 1, y), pixel)
            }

            (xMin..xMax).forEach { x ->
                addTile(Point2D(x, yMin - 1), pixel)
                addTile(Point2D(x, yMax + 1), pixel)
            }
        }
    }
}
