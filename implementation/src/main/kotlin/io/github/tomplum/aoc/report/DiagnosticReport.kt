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
        val ogr = Integer.parseInt(getOxygenGeneratorRating(0, numbers).joinToString(""), 2)
        val co2 = Integer.parseInt(getCO2ScrubberRating(0, numbers).joinToString(""), 2)
        return ogr * co2
    }

    private fun getOxygenGeneratorRating(i: Int, numbers: List<List<Int>>): List<Int> {
        val searchValue = numbers.map { it[i] }
        val mostCommon = if (searchValue.count { it == 0 } > searchValue.count { it == 1 }) 0 else 1
        val oRatingNumbers = numbers.filter { it[i] == mostCommon }
        if (oRatingNumbers.size == 1) {
            return oRatingNumbers.first()
        }
        return getOxygenGeneratorRating(i + 1, oRatingNumbers)
    }

    private fun getCO2ScrubberRating(i: Int, numbers: List<List<Int>>): List<Int> {
        val searchValue = numbers.map { it[i] }
        val mostCommon = if (searchValue.count { it == 0 } <= searchValue.count { it == 1 }) 0 else 1
        val oRatingNumbers = numbers.filter { it[i] == mostCommon }
        if (oRatingNumbers.size == 1) {
            return numbers.first { it[i] == mostCommon }
        }
        return getCO2ScrubberRating(i + 1, oRatingNumbers)
    }
}
