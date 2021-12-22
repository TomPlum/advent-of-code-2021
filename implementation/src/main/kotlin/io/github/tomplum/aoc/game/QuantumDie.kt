package io.github.tomplum.aoc.game

/**
 * A quantum die has 3 sides numbered 1, 2 & 3.
 * Each time it is rolled, a new parallel universe is created for
 * each of the possible outcomes.
 */
class QuantumDie {
    /**
     * In a game of [DiracDice], the die is rolled 3 times per turn.
     * Rolling this quantum dice has only a small set of possible outcomes
     * for the summation of those 3 values.
     *
     * For example, the smallest roll sum is (1, 1, 1) = 3.
     * And the highest is (3, 3, 3) = 9.
     *
     * There are also sums that can be achieved in different ways.
     * For example, a sum of 4 can be achieved with (1, 1, 2), (1, 2, 1) and (2, 1, 1).
     * The sums are therefore paired with a multiplier for the number of permutations of that sum.
     *
     * A list of every roll sum permutation is iterated over and the given roll [function]
     * is invoked. The value of the die roll is passed in for the game simulation and
     * the number of winning games is added to the total.
     *
     * @param function The game simulation function.
     * @return A pair of values for the number of wins for players 1 and 2 respectively.
     */
    fun forEachRollPossibility(function: (value: Int) -> Pair<Long, Long>): Pair<Long, Long> = listOf(
        Pair(9, 1), Pair(8, 3), Pair(7, 6), Pair(6, 7), Pair(5, 6), Pair(4, 3), Pair(3, 1)
    ).fold(Pair(0L, 0L)) { total, (value, multiplier) ->
        val wins = function(value)
        val playerOneWins = total.first + (wins.first * multiplier)
        val playerTwoWins = (total.second + wins.second) * multiplier
        Pair(playerOneWins, playerTwoWins)
    }
}
