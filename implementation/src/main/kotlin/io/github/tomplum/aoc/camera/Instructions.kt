package io.github.tomplum.aoc.camera

import io.github.tomplum.libs.math.map.AdventMap2D
import io.github.tomplum.libs.math.point.Point2D

class Instructions : AdventMap2D<PaperSegment>() {

    private var overlappingDots = 0

    fun addDot(pos: Point2D) {
        addTile(pos, PaperSegment('#'))
    }

    fun yFold(y: Int) {
        val yMax = yMax()!!
        val xMin = xMin()!!
        val xMax = xMax()!!
        (xMin..xMax).forEach { x ->
            (y + 1..yMax).forEach { y ->
                val currentPosition = Point2D(x, y)
                if (hasRecorded(currentPosition)) {
                    val yNew = yMax - currentPosition.y
                    val newPosition = Point2D(currentPosition.x, yNew)
                    if (hasRecorded(newPosition)) {
                        overlappingDots++;
                    }
                    addDot(newPosition)
                    removeTile(currentPosition)
                }
            }
        }
    }

    fun xFold(xFoldLine: Int) {
        val yMin = yMin()!!
        val yMax = yMax()!!
        val xMax = xMax()!!
        (xFoldLine + 1..xMax).forEach { x ->
            (yMin..yMax).forEach { y ->
                val currentPosition = Point2D(x, y)
                if (hasRecorded(currentPosition)) {
                    val xNew = xMax - currentPosition.x
                    val newPosition = Point2D(xNew, currentPosition.y)
                    if (hasRecorded(newPosition)) {
                        overlappingDots++;
                    }
                    addDot(newPosition)
                    removeTile(currentPosition)
                }
            }
        }
    }

    fun getDotCount() = filterTiles { segment -> segment.hasDot() }.count()

    override fun toString(): String {
        val yMin = yMin() ?: 0
        val yMax = yMax() ?: 0
        val xMin = xMin() ?: 0
        val xMax = xMax() ?: 0
        return (yMin..yMax).joinToString("\n") { y ->
            (xMin..xMax).joinToString(" ") { x ->
               getTile(Point2D(x, y), PaperSegment('.')).toString()
            }
        }.plus("\n")
    }
}
