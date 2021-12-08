package io.github.tomplum.aoc.display

import io.github.tomplum.aoc.display.DisplayValues.*
import io.github.tomplum.libs.logging.AdventLogger

class DisplayAnalyser(val data: List<String>) {
    fun countUniqueSegmentsInstances(): Int {
        val entries = data.map { entry ->
            val values = entry.trim().split(" | ")
            val signalPatterns = values[0].trim().split(" ")
            val outputValues = values[1].trim().split(" ")
            OutputEntry(signalPatterns, outputValues)
        }
        val sum = entries.map { entry -> entry.outputValues }.sumOf { value ->
            listOf(ONE, FOUR, SEVEN, EIGHT).sumOf { displayValues ->
                val matches = value.count { outputValue ->
                    val matches = outputValue.length == displayValues.wires.size
                    if (matches) {
                        AdventLogger.debug("$outputValue matches digit ${displayValues.value} with ${displayValues.wires}")
                    }
                    matches
                }
                matches
            }
        }
        return sum
    }
}
