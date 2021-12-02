package io.github.tomplum.aoc.navigation

data class Directive(val direction: Direction, val distance: Int) {
    companion object {
        fun fromString(value: String): Directive {
            val values = value.split(" ")
            val direction = values[0]
            val distance = values[1].toInt()
            return when(direction) {
                "forward" ->  Directive(Direction.FORWARD, distance)
                "down" ->  Directive(Direction.DOWN, distance)
                "up" ->  Directive(Direction.UP, distance)
                else -> throw IllegalArgumentException("Invalid Direction [$$direction]")
            }
        }
    }
}

