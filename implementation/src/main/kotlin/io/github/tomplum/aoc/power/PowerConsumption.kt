package io.github.tomplum.aoc.power

class PowerConsumption(val report: List<String>) {
    fun doThing(): Int {
        val values: MutableMap<Int, String> = mutableMapOf()
        report.forEach { row ->
            row.forEachIndexed { index, value ->
                values[index] = values.getOrDefault(index, "") + value
            }
        }

        val numbers = values.values.map { it.map { it.toString().toInt() } }

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
}
