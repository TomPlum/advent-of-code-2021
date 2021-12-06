package io.github.tomplum.aoc.fish

class LanternFishSimulator(private val data: String) {
    fun simulate(days: Int): Int {
        val fish = mutableMapOf<Int, Int>()
        data.trim().split(",").forEachIndexed { i, value ->
            fish[i + 1] = value.toInt()
        }

        repeat(days) {
            val iterator = fish.entries.iterator()
            var newFish = 0
            while (iterator.hasNext()) {
                val entry = iterator.next()

                if (entry.value > 0) {
                    entry.setValue(entry.value - 1)
                } else {
                    entry.setValue(6)
                    newFish++
                }
            }

            var highestId = fish.keys.maxOrNull()?.plus(1) ?: 0
            repeat(newFish) {
                fish[highestId] = 8
                highestId++
            }
        }

        return fish.size
    }
}
