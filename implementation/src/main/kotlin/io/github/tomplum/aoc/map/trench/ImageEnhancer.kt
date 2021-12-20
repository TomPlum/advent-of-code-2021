package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.logging.AdventLogger

class ImageEnhancer(private val algorithm: String, val trenchMap: TrenchMap) {
    fun applyEnhancementAlgorithm(times: Int): Int = repeat(times) { step ->
        trenchMap.addNewSurroundingCells()

        trenchMap.getPixels().keys.map { position ->
            val pixels = trenchMap.getSurroundingPixelSquare(position)
            val binaryString = pixels.joinToString("") { value -> value.toBinary().toString() }
            val algorithmIndex = Integer.parseInt(binaryString, 2)
            val outputPixel = algorithm[algorithmIndex]
            position to Pixel(outputPixel)
        }.forEach { (position, updatedPixel) ->
            trenchMap.updatePixel(position, updatedPixel)
        }
        AdventLogger.debug("Image after ${step + 1} enhancements")
        AdventLogger.debug(trenchMap)
    }.run { trenchMap.countIlluminatedPixels() }
}
