package io.github.tomplum.aoc.game

class QuantumDie {
    fun forEachRollPossibility(function: (value: Int) -> Pair<Long, Long>): Pair<Long, Long> {
        var total = Pair(0L, 0L)

        val nine = function(9)
        total = Pair(total.first + nine.first, total.second + nine.second)

        val eight = function(8)
        total = Pair(total.first + eight.first * 3, total.second + eight.second * 3)

        val seven = function(7)
        total = Pair(total.first + seven.first * 6, total.second + seven.second * 6)

        val six = function(6)
        total = Pair(total.first + six.first * 7, total.second + six.second * 7)

        val five = function(5)
        total = Pair(total.first + five.first * 6, total.second + five.second * 6)

        val four = function(4)
        total = Pair(total.first + four.first * 3, total.second + four.second * 3)

        val three = function(3)
        total = Pair(total.first + three.first, total.second + three.second)

        return total
    }
}
