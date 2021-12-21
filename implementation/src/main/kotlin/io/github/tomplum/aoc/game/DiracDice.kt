package io.github.tomplum.aoc.game

import io.github.tomplum.libs.logging.AdventLogger

class DiracDice(data: List<String>) {

    private val playerOneStartingPosition = data[0].last().toString().toInt()
    private val playerTwoStartingPosition = data[1].last().toString().toInt()

    fun play(): Int {
        var isPlayerOneTurn = true
        val die = DeterministicDie()

        var playerOneScore = 0
        var playerOnePosition = playerOneStartingPosition

        var playerTwoScore = 0
        var playerTwoPosition = playerTwoStartingPosition

        while(playerOneScore < 1000 && playerTwoScore < 1000) {
            val rolls = die.getNextThreeRolls()
            if (isPlayerOneTurn) {
                playerOnePosition = movePosition(playerOnePosition, rolls.sum())
                playerOneScore += playerOnePosition
                isPlayerOneTurn = false
            } else {
                playerTwoPosition = movePosition(playerTwoPosition, rolls.sum())
                playerTwoScore += playerTwoPosition
                isPlayerOneTurn = true
            }

            if (!isPlayerOneTurn) {
                AdventLogger.debug("Player 1 rolls ${rolls.joinToString("+")} and moves to space $playerOnePosition for a total score of $playerOneScore")
            } else {
                AdventLogger.debug("Player 2 rolls ${rolls.joinToString("+")} and moves to space $playerTwoPosition for a total score of $playerTwoScore")
            }
        }
        return die.rolls * minOf(playerOneScore, playerTwoScore)
    }

    fun playWithQuantumDice(): Long {
        var playerOneWins = 0L
        var playerTwoWins = 0L

        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 9, true, 1)
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 8, true, 1) * 3
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 7, true, 1) * 6
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 6, true, 1) * 7
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 5, true, 1) * 6
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 4, true, 1) * 3
        playerOneWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 3, true, 1)

        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 9, true, 1)
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 8, true, 1) * 3
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 7, true, 1) * 6
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 6, true, 1) * 7
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 5, true, 1) * 6
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 4, true, 1) * 3
        playerTwoWins += roll(playerOneStartingPosition, playerTwoStartingPosition, 0, 0, 3, true, 1)

        return maxOf(playerOneWins, playerTwoWins)
    }

    private fun roll(p1: Int, p2: Int, p1Score: Int, p2Score: Int, roll: Int, p1Turn: Boolean, player: Int): Long {
        var playerOnePos = p1
        var playerTwoPos = p2
        var playerOneScore = p1Score
        var playerTwoScore = p2Score
        var isPlayerOnesTurn = p1Turn

        var wins = 0L

        if (isPlayerOnesTurn) {
            playerOnePos += roll
            playerOneScore += (playerOnePos - 1) % 10 + 1
        } else {
            playerTwoPos += roll
            playerTwoScore += (playerTwoPos - 1) % 10 + 1
        }

        isPlayerOnesTurn = !isPlayerOnesTurn

        if (playerOneScore >= 21 || playerTwoScore >= 21) {
            return if (player == 1) {
                if (playerOneScore >= 21) 1 else 0
            } else {
                if (playerTwoScore >= 21) 1 else 0
            }
        } else {
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 9, isPlayerOnesTurn, player)
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 8, isPlayerOnesTurn, player) * 3
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 7, isPlayerOnesTurn, player) * 6
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 6, isPlayerOnesTurn, player) * 7
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 5, isPlayerOnesTurn, player) * 6
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 4, isPlayerOnesTurn, player) * 3
            wins += roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, 3, isPlayerOnesTurn, player)
        }
        return wins
    }

    private fun movePosition(position: Int, distance: Int): Int {
        var newPosition = position + distance
        if (newPosition > 10) {
            newPosition %= 10
        }

        if (newPosition == 0) {
            newPosition = 10
        }
        return newPosition
    }
}
