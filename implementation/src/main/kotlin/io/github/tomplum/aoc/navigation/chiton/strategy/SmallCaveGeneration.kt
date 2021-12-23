package io.github.tomplum.aoc.navigation.chiton.strategy

import io.github.tomplum.aoc.navigation.chiton.CavernPosition
import io.github.tomplum.aoc.navigation.chiton.ChitonCavern
import io.github.tomplum.libs.math.point.Point2D

class SmallCaveGeneration : CaveGenerationStrategy {
    override fun generate(data: List<String>): ChitonCavern {
        val cavern = ChitonCavern()

        var x = 0
        var y = 0
        data.forEach { row ->
            row.forEach { column ->
                cavern.addRiskLevel(Point2D(x, y), CavernPosition(column.toString().toInt()))
                x++
            }
            y++
            x = 0
        }

        return cavern
    }
}
