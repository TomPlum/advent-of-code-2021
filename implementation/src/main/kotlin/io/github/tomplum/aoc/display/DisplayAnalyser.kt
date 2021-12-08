package io.github.tomplum.aoc.display

import io.github.tomplum.aoc.display.DisplayValues.*
import io.github.tomplum.libs.logging.AdventLogger

class DisplayAnalyser(data: List<String>) {
    private val entries = data.map { entry ->
        val values = entry.trim().split(" | ")
        val signalPatterns = values[0].trim().split(" ")
        val outputValues = values[1].trim().split(" ")
        OutputEntry(signalPatterns, outputValues)
    }

    fun countUniqueSegmentsInstances(): Int {
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

    fun getOutputValueSum(): Int = entries.sumOf { (signalPatterns, outputValues) ->
        // We know 1, 4, 7 and 8 because they have unique numbers of segments per digit
        val one = ONE.withMapping(signalPatterns.find { pattern -> ONE.matchesLength(pattern) }!!)
        val four = FOUR.withMapping(signalPatterns.find { pattern -> FOUR.matchesLength(pattern) }!!)
        val seven = SEVEN.withMapping(signalPatterns.find { pattern -> SEVEN.matchesLength(pattern) }!!)
        val eight = EIGHT.withMapping(signalPatterns.find { pattern -> EIGHT.matchesLength(pattern) }!!)

        // There are three numbers that require exactly 6 segments to be illuminated
        val nine = NINE.withMapping(signalPatterns.filter { it.length == 6 }.find { pattern -> four.matchesPattern(pattern) }!!)
        val zero = ZERO.withMapping(signalPatterns.filter { it.length == 6 }.find { pattern -> !nine.matches(pattern) && one.matchesPattern(pattern) }!!)
        val six = SIX.withMapping(signalPatterns.filter { it.length == 6 }.find { pattern -> !nine.matches(pattern) && !zero.matches(pattern) }!!)

        // There are three numbers that require exactly 5 segments to be illuminated
        val three = THREE.withMapping(signalPatterns.filter { it.length == 5 }.find { pattern -> one.matchesPattern(pattern) }!!)
        val five = FIVE.withMapping(signalPatterns.filter { it.length == 5 }.find { pattern -> !three.matches(pattern) && nine.containsAll(pattern) }!!)
        val two = TWO.withMapping(signalPatterns.filter { it.length == 5 }.find { pattern -> !three.matches(pattern) && !five.matches(pattern) }!!)

        val output = outputValues.map { value ->
            val matching = listOf(zero, one, two, three, four, five, six, seven, eight, nine).find { number ->
                number.matchesMappingLength(value) && number.containsAll(value)
            }
            matching?.value ?: throw IllegalArgumentException("No matching value for $value")
        }

        val finalOutput = output.joinToString("").toInt()
        AdventLogger.debug("$outputValues: $finalOutput")
        finalOutput
    }
}
