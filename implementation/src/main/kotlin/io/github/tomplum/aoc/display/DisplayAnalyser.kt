package io.github.tomplum.aoc.display

import io.github.tomplum.aoc.display.DisplayValues.*

class DisplayAnalyser(data: List<String>) {
    private val entries = data.map { entry ->
        val values = entry.trim().split(" | ")
        val signalPatterns = SignalPatterns(values[0].trim().split(" "))
        val outputValues = values[1].trim().split(" ")
        OutputEntry(signalPatterns, outputValues)
    }

    fun countUniqueSegmentsInstances(): Int = entries.map { entry -> entry.outputValues }.sumOf { value ->
        listOf(ONE, FOUR, SEVEN, EIGHT).sumOf { displayValues ->
            value.count { outputValue -> outputValue.length == displayValues.wires.size }
        }
    }

    fun getOutputValueSum(): Int = entries.sumOf { (signalPatterns, outputValues) ->
        // We know 1, 4, 7 and 8 because they have unique numbers of segments per digit
        val one = ONE.withMapping(signalPatterns.findPatternWithSameLengthAs(ONE))
        val four = FOUR.withMapping(signalPatterns.findPatternWithSameLengthAs(FOUR))
        val seven = SEVEN.withMapping(signalPatterns.findPatternWithSameLengthAs(SEVEN))
        val eight = EIGHT.withMapping(signalPatterns.findPatternWithSameLengthAs(EIGHT))

        // There are three numbers that require exactly 6 segments to be illuminated
        val sixLengthPatterns = signalPatterns.getPatternsWithLength(6)
        val nine = NINE.withMapping(sixLengthPatterns.find { pattern -> four.matchesPattern(pattern) }!!)
        val zero = ZERO.withMapping(sixLengthPatterns.find { pattern -> !nine.matches(pattern) && one.matchesPattern(pattern) }!!)
        val six = SIX.withMapping(sixLengthPatterns.find { pattern -> !nine.matches(pattern) && !zero.matches(pattern) }!!)

        // There are three numbers that require exactly 5 segments to be illuminated
        val fiveLengthPatterns = signalPatterns.getPatternsWithLength(5)
        val three = THREE.withMapping(fiveLengthPatterns.find { pattern -> one.matchesPattern(pattern) }!!)
        val five = FIVE.withMapping(fiveLengthPatterns.find { pattern -> !three.matches(pattern) && nine.containsAll(pattern) }!!)
        val two = TWO.withMapping(fiveLengthPatterns.find { pattern -> !three.matches(pattern) && !five.matches(pattern) }!!)

        // Now we have all the wires mapped, matches the output values and build the output value
        outputValues.map { value ->
            listOf(zero, one, two, three, four, five, six, seven, eight, nine).find { number ->
                number.matchesMappingLength(value) && number.containsAll(value)
            }?.value ?: throw IllegalArgumentException("No matching value for $value")
        }.joinToString("").toInt()
    }
}
