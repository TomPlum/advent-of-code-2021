package io.github.tomplum.aoc.report

class DiagnosticReport(private val data: List<String>) {
    fun calculatePowerConsumption(): Int {
        val vertical: MutableMap<Int, String> = mutableMapOf()
        data.forEach { row ->
            row.forEachIndexed { index, value ->
                vertical[index] = vertical.getOrDefault(index, "") + value
            }
        }

        val numbers = vertical.values.map { it.map { it.toString().toInt() } }

        val mostCommon = numbers.map { values ->
            if (values.count { it == 0 } > values.count { it == 1 }) {
                0
            } else {
                1
            }
        }
        val gammaRate = Integer.parseInt(mostCommon.joinToString(""), 2)

        val leastCommon = numbers.map { values ->
            if (values.count { it == 0 } > values.count { it == 1 }) {
                1
            } else {
                0
            }
        }

        val epsilonRate = Integer.parseInt(leastCommon.joinToString(""), 2)

        return gammaRate * epsilonRate
    }

    fun calculateLifeSupportRating(): Int {
        val numbers = data.map { row -> row.map { it.toString().toInt() } }
        val ogr = Integer.parseInt(getOxygenGeneratorRating(numbers).joinToString(""), 2)
        val co2 = Integer.parseInt(getCO2ScrubberRating(numbers).joinToString(""), 2)
        return ogr * co2
    }

    private fun getOxygenGeneratorRating(numbers: List<List<Int>>): List<Int> {
        val commonFunction = { number: List<Int> ->
            if (number.count { it == 0 } > number.count { it == 1 }) 0 else 1
        }
        return findRatingValue(commonFunction, numbers)
    }

    private fun getCO2ScrubberRating(numbers: List<List<Int>>): List<Int> {
        val commonFunction = { number: List<Int> ->
            if (number.count { it == 0 } <= number.count { it == 1 }) 0 else 1
        }
        return findRatingValue(commonFunction, numbers)
    }

    private fun findRatingValue(commonFunction: (search: List<Int>) -> Int, numbers: List<List<Int>>, i: Int = 0): List<Int> {
        val searchValue = numbers.map { it[i] }
        val mostCommon = commonFunction(searchValue)
        val ratingNumbers = numbers.filter { it[i] == mostCommon }
        if (ratingNumbers.size == 1) {
            return numbers.first { it[i] == mostCommon }
        }
        return findRatingValue(commonFunction, ratingNumbers, i + 1)
    }
}
