package io.github.tomplum.aoc.navigation.depth.strategy

import io.github.tomplum.aoc.navigation.depth.Command
import io.github.tomplum.aoc.navigation.depth.PositionReport

interface NavigationStrategy {
    fun calculatePositionReport(commands: Collection<Command>): PositionReport
}
