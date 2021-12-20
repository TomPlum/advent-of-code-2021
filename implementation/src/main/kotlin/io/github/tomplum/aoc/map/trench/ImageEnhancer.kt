package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.logging.AdventLogger

class ImageEnhancer(private val algorithm: String, private val map: TrenchMap) {
    fun applyEnhancementAlgorithm(times: Int): Int = (1..times).forEach { step ->
        map.addNewSurroundingCells()

        map.getPixelPositions().map { position ->
            position to map.getSurroundingPixelSquare(position, step)
                .joinToString("") { value -> value.toBinary().toString() }
                .toInt(2)
                .let { algorithmIndex -> algorithm[algorithmIndex] }
                .let { value -> Pixel(value) }
        }.forEach { (position, updatedPixel) ->
            map.updatePixel(position, updatedPixel)
        }

        AdventLogger.debug("Image after $step enhancements")
        AdventLogger.debug(map)
    }.run { map.countIlluminatedPixels() }
}
