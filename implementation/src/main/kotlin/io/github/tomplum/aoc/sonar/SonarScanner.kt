package io.github.tomplum.aoc.sonar

class SonarScanner(private val report: List<Int>) {
    fun sweep(): Int = report.windowed(2).fold(0) { acc, depths ->
        val last = depths[0]
        val current = depths[1]
        if (current > last) acc + 1 else acc
    }
}
