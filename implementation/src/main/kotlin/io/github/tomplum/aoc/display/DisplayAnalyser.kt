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

    fun getOutputValueSum(): Int {
        val display = SevenSegmentDisplay()

        return entries.sumOf { (signalPatterns, outputValues) ->
            val one = signalPatterns.find { pattern ->  pattern.length == ONE.wires.size }!!
            val four = signalPatterns.find { pattern ->  pattern.length == FOUR.wires.size }!!
            val seven = signalPatterns.find { pattern ->  pattern.length == SEVEN.wires.size }!!
            val eight = signalPatterns.find { pattern ->  pattern.length == EIGHT.wires.size }!!

            val nine = signalPatterns.filter { it.length == 6 }.find { pattern -> four.all { value -> value in pattern } }!!
            val zero = signalPatterns.filter { it.length == 6 }.find { pattern -> pattern != nine && one.all { value -> value in pattern } }
            val six = signalPatterns.filter { it.length == 6 }.find { pattern -> pattern != nine && pattern != zero }

            val three = signalPatterns.filter { it.length == 5 }.find { pattern -> one.all { value -> value in pattern } }
            val five = signalPatterns.filter { it.length == 5 }.find { pattern -> pattern != three && pattern.all { value -> value in nine } }
            val two = signalPatterns.filter { it.length == 5 }.find { pattern -> pattern != three && pattern != five }

/*            listOf(zero, one, two, three, four, five, six, seven, eight, nine).forEach { wires ->
                wires?.toList()?.forEachIndexed { i, value ->
                    if (i == 0) {
                        display.setSegmentA(value)
                    }
                    if (i == 1) {
                        display.setSegmentB(value)
                    }
                    if (i == 2) {
                        display.setSegmentC(value)
                    }
                    if (i == 3) {
                        display.setSegmentD(value)
                    }
                    if (i == 4) {
                        display.setSegmentE(value)
                    }
                    if (i == 5) {
                        display.setSegmentF(value)
                    }
                    if (i == 6) {
                        display.setSegmentG(value)
                    }
                }
            }*/
            val output = outputValues.map { value ->
                val matching = listOf(zero, one, two, three, four, five, six, seven, eight, nine).find { pattern ->
                    value.length == pattern?.length && value.all { it in pattern }
                }
                when(matching) {
                    zero -> 0
                    one -> 1
                    two -> 2
                    three -> 3
                    four -> 4
                    five -> 5
                    six -> 6
                    seven -> 7
                    eight -> 8
                    nine -> 9
                    else -> throw IllegalArgumentException("Invalid Wire Mapping")
                }
            }

            val finalOutput = output.joinToString("").toInt()
            AdventLogger.debug("$outputValues: $finalOutput")
            finalOutput
        }
    }
}
