package io.github.tomplum.aoc.game

class DiracDice(data: List<String>) {

    private val playerOneStart = data[0].last().toString().toInt()
    private val playerTwoStart = data[1].last().toString().toInt()

    private val quantumDie = QuantumDie()

    fun play(): Int {
        var isPlayerOneTurn = true

        val die = DeterministicDie()
        val playerOne = Player(playerOneStart)
        val playerTwo = Player(playerTwoStart)

        while(playerOne.score < 1000 && playerTwo.score < 1000) {
            val distance = die.getNextThreeRolls().sum()
            if (isPlayerOneTurn) {
                playerOne.move(distance)
            } else {
                playerTwo.move(distance)
            }
            isPlayerOneTurn = !isPlayerOneTurn
        }

        return die.rolls * minOf(playerOne.score, playerTwo.score)
    }

    fun playWithQuantumDice(): Long {
        var playerOneWins = 0L
        var playerTwoWins = 0L

        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 9, true, 1)
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 8, true, 1) * 3
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 7, true, 1) * 6
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 6, true, 1) * 7
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 5, true, 1) * 6
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 4, true, 1) * 3
        playerOneWins += roll(playerOneStart, playerTwoStart, 0, 0, 3, true, 1)

        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 9, true, 2)
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 8, true, 2) * 3
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 7, true, 2) * 6
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 6, true, 2) * 7
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 5, true, 2) * 6
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 4, true, 2) * 3
        playerTwoWins += roll(playerOneStart, playerTwoStart, 0, 0, 3, true, 2)

        return maxOf(playerOneWins, playerTwoWins)
    }

    fun playWithQuantumDice2(): Long {
        var playerOneWins = 0L
        var playerTwoWins = 0L

        val playerOne = Player(playerOneStart)
        val playerTwo = Player(playerTwoStart)

        playerOneWins += roll(playerOne, playerTwo, 9, true, 1)
        playerOneWins += roll(playerOne, playerTwo, 8, true, 1) * 3
        playerOneWins += roll(playerOne, playerTwo, 7, true, 1) * 6
        playerOneWins += roll(playerOne, playerTwo, 6, true, 1) * 7
        playerOneWins += roll(playerOne, playerTwo, 5, true, 1) * 6
        playerOneWins += roll(playerOne, playerTwo, 4, true, 1) * 3
        playerOneWins += roll(playerOne, playerTwo, 3, true, 1)

        playerTwoWins += roll(playerOne, playerTwo, 9, true, 2)
        playerTwoWins += roll(playerOne, playerTwo, 8, true, 2) * 3
        playerTwoWins += roll(playerOne, playerTwo, 7, true, 2) * 6
        playerTwoWins += roll(playerOne, playerTwo, 6, true, 2) * 7
        playerTwoWins += roll(playerOne, playerTwo, 5, true, 2) * 6
        playerTwoWins += roll(playerOne, playerTwo, 4, true, 2) * 3
        playerTwoWins += roll(playerOne, playerTwo, 3, true, 2)


        return maxOf(playerOneWins, playerTwoWins)
    }

    private fun roll(p1: Player, p2: Player, roll: Int, p1Turn: Boolean, player: Int): Long {
        var wins = 0L

        if (p1Turn) {
            p1.position += roll
            p1.score += (p1.position - 1) % 10 + 1
        } else {
            p2.position += roll
            p2.score += (p2.position - 1) % 10 + 1
        }

        if (p1.score >= 21 || p2.score >= 21) {
            return if (player == 1) {
                if (p1.score >= 21) 1 else 0
            } else {
                if (p2.score >= 21) 1 else 0
            }
        } else {
            wins += roll(p1.copy(), p2.copy(), 9, !p1Turn, player)
            wins += roll(p1.copy(), p2.copy(), 8, !p1Turn, player) * 3
            wins += roll(p1.copy(), p2.copy(), 7, !p1Turn, player) * 6
            wins += roll(p1.copy(), p2.copy(), 6, !p1Turn, player) * 7
            wins += roll(p1.copy(), p2.copy(), 5, !p1Turn, player) * 6
            wins += roll(p1.copy(), p2.copy(), 4, !p1Turn, player) * 3
            wins += roll(p1.copy(), p2.copy(), 3, !p1Turn, player)
        }

        return wins
    }

    fun roll(p1: Int, p2: Int, p1Score: Int, p2Score: Int, roll: Int, p1Turn: Boolean, player: Int): Long {
        var playerOnePos = p1
        var playerTwoPos = p2
        var playerOneScore = p1Score
        var playerTwoScore = p2Score

        var wins = 0L

        if (p1Turn) {
            playerOnePos += roll
            playerOneScore += (playerOnePos - 1) % 10 + 1
        } else {
            playerTwoPos += roll
            playerTwoScore += (playerTwoPos - 1) % 10 + 1
        }


        if (playerOneScore >= 21 || playerTwoScore >= 21) {
            return if (player == 1) {
                if (playerOneScore >= 21) 1 else 0
            } else {
                if (playerTwoScore >= 21) 1 else 0
            }
        } else {
            wins += quantumDie.forEachRollPossibility { value ->
                roll(playerOnePos, playerTwoPos, playerOneScore, playerTwoScore, value, !p1Turn, player)
            }
        }
        return wins
    }
}
