package io.github.tomplum.aoc.navigation

import io.github.tomplum.aoc.navigation.strategy.NavigationStrategy

class DepthMeter(private val course: List<String>) {
    fun calculateCourseDestination(strategy: NavigationStrategy): PositionReport {
        val directives = course.map { entry -> Directive.fromString(entry) }
        return strategy.calculatePositionReport(directives)
    }
}
