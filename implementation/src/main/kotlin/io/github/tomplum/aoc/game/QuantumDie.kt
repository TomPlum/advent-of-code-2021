package io.github.tomplum.aoc.game

class QuantumDie {
    fun forEachRollPossibility(function: (value: Int) -> Long): Long {
        var total = 0L
        total += function(9)
        total += function(8) * 3
        total += function(7) * 6
        total += function(6) * 7
        total += function(5) * 6
        total += function(4) * 3
        total += function(3)
        return total
    }
}
