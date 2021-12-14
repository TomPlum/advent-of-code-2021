package io.github.tomplum.aoc.polymer

class Polymeriser(val data: List<String>) {
    fun doThing(steps: Int): Int {
        val template = data.first().trim()
        val rules = data.takeLastWhile { line -> line != "" }
        val pairs = mutableMapOf<String, Int>()
        template.zipWithNext { a, b ->
            pairs["$a$b"] = pairs.getOrDefault("$a$b", 0) + 1
        }
        repeat(steps) { step ->
            val updates = mutableMapOf<String, Int>()
            rules.forEach { rule ->
                val values = rule.split(" -> ")
                val pair = values[0]
                val target = values[1].first()
                val occurrences = pairs.getOrDefault(pair, 0)
                if (occurrences > 0) {
                    updates["${pair.first()}$target"] = updates.getOrDefault("${pair.first()}$target", 0) + occurrences
                    updates["$target${pair.last()}"] = updates.getOrDefault("$target${pair.last()}", 0) + occurrences
                }
                pairs[pair] = 0
            }
            updates.forEach { (pair, occurrences) -> pairs[pair] = pairs.getOrDefault(pair, 0) + occurrences }
        }
        val elements = rules.map { rule -> rule.split(" -> ")[1].last() }.distinct()
        val occurrences = elements.associateWith { element ->
            pairs.map { (pair, occurrences) ->
                pair.count { char -> char == element } * occurrences
            }.sum() / 2
        }
        return occurrences.values.last() - occurrences.values.first()
    }
}
