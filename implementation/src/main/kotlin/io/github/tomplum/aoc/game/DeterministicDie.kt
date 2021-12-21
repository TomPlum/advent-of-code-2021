package io.github.tomplum.aoc.game

class DeterministicDie {
    var rolls = 0
    var value = 1

    fun getNextThreeRolls(): List<Int> {
        val values = mutableListOf<Int>()

        repeat(3) {
            values.add(value)

            value++
            rolls++

            if (value > 100) {
                value = 1
            }
        }

        return values
    }
}
