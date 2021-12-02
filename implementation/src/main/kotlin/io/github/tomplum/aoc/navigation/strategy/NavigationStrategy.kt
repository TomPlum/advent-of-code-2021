package io.github.tomplum.aoc.navigation.strategy

import io.github.tomplum.aoc.navigation.Command
import io.github.tomplum.aoc.navigation.PositionReport

interface NavigationStrategy {
    fun calculatePositionReport(commands: Collection<Command>): PositionReport
}
