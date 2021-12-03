package io.github.tomplum.aoc.report

import io.github.tomplum.libs.extensions.toDecimal

class DiagnosticReport(private val data: List<String>) {
    fun calculatePowerConsumption(): Long {
        val vertical: MutableMap<Int, String> = mutableMapOf()
        data.forEach { row ->
            row.forEachIndexed { index, value ->
                vertical[index] = vertical.getOrDefault(index, "") + value
            }
        }

        val numbers = vertical.values.map { value -> value.map { number -> number.toString().toInt() }.toIntArray() }

        val mostCommon = numbers.map { values -> if (values.count { it == 0 } > values.size / 2) 0 else 1 }
        val gammaRate = mostCommon.toIntArray().toDecimal()

        val leastCommon = numbers.map { values -> if (values.count { it == 0 } > values.size / 2) 1 else 0 }
        val epsilonRate = leastCommon.toIntArray().toDecimal()

        return gammaRate * epsilonRate
    }

    fun calculateLifeSupportRating(): Int {
        val numbers = data.map { row -> row.map { it.toString().toInt() } }
        val ogr = Integer.parseInt(getOxygenGeneratorRating(numbers).joinToString(""), 2)
        val co2 = Integer.parseInt(getCO2ScrubberRating(numbers).joinToString(""), 2)
        return ogr * co2
    }

    private fun getOxygenGeneratorRating(numbers: List<List<Int>>): List<Int> {
        val commonFunction = { number: List<Int> -> if (number.count { it == 0 } > number.count { it == 1 }) 0 else 1 }
        return findRatingValue(commonFunction, numbers)
    }

    private fun getCO2ScrubberRating(numbers: List<List<Int>>): List<Int> {
        val commonFunction = { number: List<Int> -> if (number.count { it == 0 } <= number.count { it == 1 }) 0 else 1 }
        return findRatingValue(commonFunction, numbers)
    }

    private fun findRatingValue(common: (search: List<Int>) -> Int, numbers: List<List<Int>>, i: Int = 0): List<Int> {
        val searchValue = numbers.map { binary -> binary[i] }
        val mostCommon = common(searchValue)
        val ratingNumbers = numbers.filter { binary -> binary[i] == mostCommon }
        if (ratingNumbers.size == 1) {
            return numbers.first { binary -> binary[i] == mostCommon }
        }
        return findRatingValue(common, ratingNumbers, i + 1)
    }
}
