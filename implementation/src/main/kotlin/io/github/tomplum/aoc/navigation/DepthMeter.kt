package io.github.tomplum.aoc.navigation

import io.github.tomplum.aoc.navigation.strategy.NavigationStrategy


class DepthMeter(private val course: List<String>) {
    fun calculateCourseDestination(strategy: NavigationStrategy): PositionReport {
        val directives = course.map { entry ->
            val values = entry.split(" ")
            when(values[0]) {
                "forward" ->  Directive(Direction.FORWARD, values[1].toInt())
                "down" ->  Directive(Direction.DOWN, values[1].toInt())
                "up" ->  Directive(Direction.UP, values[1].toInt())
                else -> throw IllegalArgumentException("Invalid Direction [$${values[0]}]")
            }
        }

        return strategy.calculatePositionReport(directives)
    }
}
