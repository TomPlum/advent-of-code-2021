package io.github.tomplum.aoc.navigation.strategy

import io.github.tomplum.aoc.navigation.Direction
import io.github.tomplum.aoc.navigation.Command
import io.github.tomplum.aoc.navigation.PositionReport

class ImprovedNavigation : NavigationStrategy {
    override fun calculatePositionReport(commands: Collection<Command>): PositionReport {
        var aim = 0
        var depth = 0
        var horizontal = 0

        commands.forEach { directive ->
            when(directive.direction) {
                Direction.FORWARD -> {
                    horizontal += directive.distance
                    depth += aim * directive.distance
                }
                Direction.DOWN -> aim += directive.distance
                Direction.UP -> aim -= directive.distance
            }
        }

        return PositionReport(horizontal, depth)
    }
}
