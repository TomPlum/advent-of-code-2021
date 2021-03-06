package io.github.tomplum.aoc.navigation.cave

import io.github.tomplum.libs.logging.AdventLogger
import java.util.*

class PathingSystem(val data: List<String>) {

    private val startingCave = "start"
    private val finishingCave = "end"

    private val caves = mutableMapOf<String, List<String>>()
    private val visited = mutableSetOf<String>()

    private val paths = mutableListOf<List<String>>()
    private var currentPath = Stack<String>()

    private val singleVisitCaveFilter = { cave: String -> cave.isBigCave() || cave !in currentPath }

    init {
        data.forEach { entry ->
            val values = entry.split("-")

            val leftMappings = caves.getOrDefault(values[0], mutableListOf()).toMutableList()
            leftMappings.add(values[1])
            caves[values[0]] = leftMappings.filter { it != startingCave }

            val rightMappings = caves.getOrDefault(values[1], mutableListOf()).toMutableList()
            rightMappings.add(values[0])
            caves[values[1]] = rightMappings.filter { it != startingCave }
        }
    }

    fun findPathsVisitingSmallCaves(): Int {
        discoverPaths(singleVisitCaveFilter)
        return paths.size
    }

    fun findPathsVisitingSmallCaveTwice(): Int = caves.keys
        .filter { key -> key.isSmallCave() }
        .filter { cave -> cave !in listOf(startingCave, finishingCave) }
        .forEach { smallCave ->
            discoverPaths { cave ->
                val matchesSingleVisit = singleVisitCaveFilter(cave)
                val matchesDoubleVisit = (cave == smallCave && currentPath.count { path -> path == smallCave } < 2)
                matchesSingleVisit || matchesDoubleVisit
            }
        }
        .run { paths.distinct().size }

    private fun discoverPaths(targetCaveFilter: (cave: String) -> Boolean) {
        caves[startingCave]?.forEach { target ->
            currentPath.push(startingCave)
            dfs(startingCave, target, targetCaveFilter)
            currentPath.clear()
            visited.clear()
        }
    }

    private fun dfs(source: String, target: String, filter: (cave: String) -> Boolean) {
        visited.add(target)
        currentPath.push(target)

        val next = Stack<String>()
        if (target == finishingCave) {
            AdventLogger.debug(currentPath.joinToString(","))
            paths.add(currentPath.toList())
        } else {
            caves.getOrDefault(target, emptyList())
                .filter { targetCave -> filter(targetCave) }
                .let { nextTargets -> next.addAll(nextTargets) }
        }

        while(next.isNotEmpty()) {
            dfs(source, next.pop(), filter)
        }

        currentPath.removeLast()
    }

    private fun String.isSmallCave() = this.all { char -> char.isLowerCase() }
    private fun String.isBigCave() = this.all { char -> char.isUpperCase() }
}
