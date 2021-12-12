package io.github.tomplum.aoc.navigation.cave

import io.github.tomplum.libs.logging.AdventLogger
import java.util.*

class PathingSystem(val data: List<String>) {

    val mapping = mutableMapOf<String, List<String>>()
    val paths = mutableListOf<List<String>>()
    var currentPath = Stack<String>()
    val visited = mutableSetOf<String>()

    init {
        data.forEach { entry ->
            val values = entry.split("-")

            val leftMappings = mapping.getOrDefault(values[0], mutableListOf()).toMutableList()
            leftMappings.add(values[1])
            mapping[values[0]] = leftMappings

            val rightMappings = mapping.getOrDefault(values[1], mutableListOf()).toMutableList()
            rightMappings.add(values[0])
            mapping[values[1]] = rightMappings
        }
    }

    fun findPathsVisitingSmallCaves(): Int {
        mapping["start"]?.forEach { target ->
            currentPath.push("start")
            dfs("start", target)
            currentPath.clear()
            visited.clear()
        }

        return paths.size
    }

    private fun dfs(source: String, target: String) {
        visited.add(target)
        currentPath.push(target)

        val next = Stack<String>()
        if (target != "end") {
            val nextTargets = mapping.getOrDefault(target, emptyList())
                .filter { it.all { char -> char.isUpperCase() } || it !in currentPath }
            next.addAll(nextTargets)
        } else {
            AdventLogger.debug(currentPath.joinToString(","))
            paths.add(currentPath)
        }

        while(next.isNotEmpty()) {
            dfs(source, next.pop())
        }

        currentPath.removeLast()
    }
}
