package io.github.tomplum.aoc.sonar

class SonarScanner(private val report: List<Int>) {
    fun sweep(): Int = report.windowed(2).fold(0) { acc, depths ->
        val last = depths[0]
        val current = depths[1]
        if (current > last) acc + 1 else acc
    }

    fun sweepWindowed(size: Int): Int = report.windowed(size * 2).fold(0) { acc, depths ->
        val last = depths.subList(0, 1).sum()
        val current = depths.subList(3, 5).sum()
        if (current > last) acc + 1 else acc
    }
}
