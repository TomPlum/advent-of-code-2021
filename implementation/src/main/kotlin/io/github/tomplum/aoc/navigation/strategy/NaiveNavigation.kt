package io.github.tomplum.aoc.navigation.strategy

import io.github.tomplum.aoc.navigation.Direction
import io.github.tomplum.aoc.navigation.Command
import io.github.tomplum.aoc.navigation.PositionReport

class NaiveNavigation : NavigationStrategy {
    override fun calculatePositionReport(commands: Collection<Command>): PositionReport {
        var depth = 0
        var horizontal = 0

        commands.forEach { directive ->
            when(directive.direction) {
                Direction.FORWARD -> horizontal += directive.distance
                Direction.DOWN -> depth += directive.distance
                Direction.UP -> depth -= directive.distance
            }
        }

        return PositionReport(horizontal, depth)
    }
}
