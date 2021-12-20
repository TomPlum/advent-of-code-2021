package io.github.tomplum.aoc.map.trench

import io.github.tomplum.libs.logging.AdventLogger

class ImageEnhancer(private val algorithm: String, val trenchMap: TrenchMap) {
    fun applyEnhancementAlgorithm(times: Int): Int = repeat(times) { step ->
        val keys = trenchMap.getPixels().keys
        trenchMap.addNewSurroundingCells(1)

        keys.map { position ->
            val pixels = trenchMap.getSurroundingPixelSquare(position).map {
                if (it.value == '?') {
                    if ((step + 1) % 2 == 0) Pixel('#') else Pixel('.')
                } else it
            }
            val binaryString = pixels.joinToString("") { value -> "${value.toBinary(step + 1)}" }
            val algorithmIndex = binaryString.toInt(2)
            val outputPixel = algorithm[algorithmIndex]
            position to Pixel(outputPixel)
        }.forEach { (position, updatedPixel) ->
            trenchMap.updatePixel(position, updatedPixel)
        }
        trenchMap.addNewSurroundingCells(1)
        AdventLogger.debug("Image after ${step + 1} enhancements")
        AdventLogger.debug(trenchMap)
    }.run { trenchMap.countIlluminatedPixels() }
}
