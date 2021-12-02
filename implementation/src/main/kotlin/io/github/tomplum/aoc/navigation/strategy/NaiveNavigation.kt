package io.github.tomplum.aoc.navigation.strategy

import io.github.tomplum.aoc.navigation.Direction
import io.github.tomplum.aoc.navigation.Directive
import io.github.tomplum.aoc.navigation.PositionReport

class NaiveNavigation : NavigationStrategy {
    override fun calculatePositionReport(directives: Collection<Directive>): PositionReport {
        var horizontal = 0
        var depth = 0

        directives.forEach { directive ->
            when(directive.direction) {
                Direction.FORWARD -> horizontal += directive.distance
                Direction.DOWN -> depth += directive.distance
                Direction.UP -> depth -= directive.distance
            }
        }

        return PositionReport(horizontal, depth)
    }
}
