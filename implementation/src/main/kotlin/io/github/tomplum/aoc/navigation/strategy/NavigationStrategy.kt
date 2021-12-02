package io.github.tomplum.aoc.navigation.strategy

import io.github.tomplum.aoc.navigation.Directive
import io.github.tomplum.aoc.navigation.PositionReport

interface NavigationStrategy {
    fun calculatePositionReport(directives: Collection<Directive>): PositionReport
}
