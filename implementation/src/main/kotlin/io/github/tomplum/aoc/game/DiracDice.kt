package io.github.tomplum.aoc.game

import io.github.tomplum.libs.logging.AdventLogger

class DiracDice(data: List<String>) {

    private var dieRolls = 0
    private var dieValue = 1
    private var isPlayerOneTurn = true

    private var playerOneScore = 0
    private var playerOnePosition = data[0].last().toString().toInt()

    private var playerTwoScore = 0
    private var playerTwoPosition = data[1].last().toString().toInt()

    fun play(): Int {
        while(playerOneScore < 1000 && playerTwoScore < 1000) {
            val rolls = getDeterministicDiceRolls()
            if (isPlayerOneTurn) {
                movePosition(1, rolls.sum())
                playerOneScore += playerOnePosition
                isPlayerOneTurn = false
            } else {
                movePosition(2, rolls.sum())
                playerTwoScore += playerTwoPosition
                isPlayerOneTurn = true
            }
            if (!isPlayerOneTurn) {
                AdventLogger.debug("Player 1 rolls ${rolls.joinToString("+")} and moves to space $playerOnePosition for a total score of $playerOneScore")
            } else {
                AdventLogger.debug("Player 2 rolls ${rolls.joinToString("+")} and moves to space $playerTwoPosition for a total score of $playerTwoScore")
            }
        }
        return dieRolls * minOf(playerOneScore, playerTwoScore)
    }

    private fun movePosition(player: Int, distance: Int) {
        if (player == 1) {
            var newPosition = playerOnePosition + distance
            if (newPosition > 10) {
                newPosition %= 10
            }

            if (newPosition == 0) {
                newPosition = 10
            }
            playerOnePosition = newPosition
        }
        if (player == 2) {
            var newPosition = playerTwoPosition + distance
            if (newPosition > 10) {
                newPosition %= 10
            }
            if (newPosition == 0) {
                newPosition = 10
            }
            playerTwoPosition = newPosition
        }
    }

    private fun getDeterministicDiceRolls(): List<Int> {
        val rolls = mutableListOf<Int>()
        repeat(3) {
            rolls.add(dieValue)
            dieValue++
            dieRolls++
            if (dieValue > 100) {
                dieValue = 1
            }
        }
        return rolls
    }
}
