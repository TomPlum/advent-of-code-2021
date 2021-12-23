package io.github.tomplum.aoc.navigation.chiton.strategy

import io.github.tomplum.aoc.navigation.chiton.CavernPosition
import io.github.tomplum.aoc.navigation.chiton.ChitonCavern
import io.github.tomplum.libs.math.point.Point2D

class LargeCaveGeneration : CaveGenerationStrategy {
    override fun generate(data: List<String>): ChitonCavern {
        val cavern = ChitonCavern()

        var x = 0
        var y = 0
        val width = data.first().length

        data.forEach { row ->
            row.forEach { column ->
                val risk = column.toString().toInt()
                (0 until 5).forEach { xTranslate ->
                    (0 until 5).forEach { yTranslate ->
                        val xPos = x + xTranslate * width
                        val yPos = y + yTranslate * width
                        val translateRisk = (risk + xTranslate + yTranslate)
                        val normalisedRisk = if (translateRisk > 9) (translateRisk % 9) else translateRisk
                        cavern.addRiskLevel(Point2D(xPos, yPos), CavernPosition(normalisedRisk))
                    }
                }

                x++
            }
            y++
            x = 0
        }

        return cavern
    }
}
