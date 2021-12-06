package io.github.tomplum.aoc.fish

class LanternFishSimulator(private val data: String) {
    fun simulate(days: Int): Long {
        val fish = data.trim().split(",")
            .groupBy { age -> age }
            .map { (age, quantity) -> age.toInt() to quantity.size.toLong() }
            .toMap().toMutableMap()

        repeat(days) {
            val newAges = fish.map { (age, quantity) ->
                (if (age == 0) 6 else age - 1) to quantity
            }

            val newFish = (8 to (fish[0] ?: 0))

            fish.clear()

            (newAges + newFish).forEach { (age, quantity) ->
                fish[age] = (fish[age] ?: 0) + quantity
            }
        }

        return fish.values.sum()
    }
}
