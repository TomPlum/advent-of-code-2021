package io.github.tomplum.aoc.game

data class Player(var position: Int) {
    var score = 0

    fun move(distance: Int) {
        var newPosition = position + distance
        if (newPosition > 10) {
            newPosition %= 10
        }

        if (newPosition == 0) {
            newPosition = 10
        }

        position = newPosition
        score += position
    }

}
