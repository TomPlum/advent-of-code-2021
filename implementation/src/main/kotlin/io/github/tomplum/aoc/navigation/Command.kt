package io.github.tomplum.aoc.navigation

data class Command(val direction: Direction, val distance: Int) {
    companion object {
        fun fromString(value: String): Command {
            val values = value.split(" ")
            val direction = values[0]
            val distance = values[1].toInt()
            return when(direction) {
                "forward" ->  Command(Direction.FORWARD, distance)
                "down" ->  Command(Direction.DOWN, distance)
                "up" ->  Command(Direction.UP, distance)
                else -> throw IllegalArgumentException("Invalid Direction [$$direction]")
            }
        }
    }
}

