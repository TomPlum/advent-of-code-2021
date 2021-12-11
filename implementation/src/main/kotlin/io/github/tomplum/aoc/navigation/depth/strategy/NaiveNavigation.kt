package io.github.tomplum.aoc.navigation.depth.strategy

import io.github.tomplum.aoc.navigation.depth.Direction
import io.github.tomplum.aoc.navigation.depth.Command
import io.github.tomplum.aoc.navigation.depth.PositionReport

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
