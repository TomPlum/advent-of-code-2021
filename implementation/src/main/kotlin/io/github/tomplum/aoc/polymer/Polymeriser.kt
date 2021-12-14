package io.github.tomplum.aoc.polymer

class Polymeriser(val data: List<String>) {
    fun calculateElementOccurrenceBoundaryDifference(steps: Int): Long {
        val rules = data
            .takeLastWhile { line -> line != "" }
            .map { rule -> rule.split(" -> ") }
            .associate { terms -> terms[0] to terms[1].first() }

        val pairs = mutableMapOf<String, Long>()
        data.first().trim().zipWithNext { a, b ->
            pairs["$a$b"] = pairs.getOrDefault("$a$b", 0) + 1
        }

        repeat(steps) {
            val updates = mutableMapOf<String, Long>()
            rules.forEach { (pair, element) ->
                val count = pairs.getOrDefault(pair, 0L)

                if (count > 0) {
                    val leftPair = "${pair.first()}$element"
                    updates[leftPair] = updates.getOrDefault(leftPair, 0L) + count

                    val rightPair = "$element${pair.last()}"
                    updates[rightPair] = updates.getOrDefault(rightPair, 0L) + count
                }

                pairs[pair] = 0
            }
            updates.forEach { (pair, occurrences) -> pairs[pair] = pairs.getOrDefault(pair, 0) + occurrences }
        }

        val occurrences = rules.values.map { element ->
            val total = pairs.map { (pair, count) -> pair.count { char -> char == element } * count }.sum()
            (if (total % 2 == 1L) total + 1 else total) / 2
        }.sorted()

        return occurrences.last() - occurrences.first()
    }
}
