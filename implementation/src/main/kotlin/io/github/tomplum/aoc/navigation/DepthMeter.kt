package io.github.tomplum.aoc.navigation


class DepthMeter(val course: List<String>) {
    fun calculateCourseDestination(): PositionReport {
        val directives = course.map { entry ->
            val values = entry.split(" ")
            when(values[0]) {
                "forward" ->  Directive(Direction.FORWARD, values[1].toInt())
                "down" ->  Directive(Direction.DOWN, values[1].toInt())
                "up" ->  Directive(Direction.UP, values[1].toInt())
                else -> throw IllegalArgumentException("Invalid Direction [$${values[0]}]")
            }
        }
    }

}
