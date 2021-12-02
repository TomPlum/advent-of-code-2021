package io.github.tomplum.aoc.navigation

data class PositionReport(val horizontal: Int, val depth: Int) {
    fun getUnifiedValue() = horizontal * depth
}
