package io.github.tomplum.aoc.navigation.cave

import io.github.tomplum.libs.logging.AdventLogger
import java.util.*

class PathingSystem(val data: List<String>) {

    private val mapping = mutableMapOf<String, List<String>>()
    private val paths = mutableListOf<List<String>>()
    private var currentPath = Stack<String>()
    private val visited = mutableSetOf<String>()

    init {
        data.forEach { entry ->
            val values = entry.split("-")

            val leftMappings = mapping.getOrDefault(values[0], mutableListOf()).toMutableList()
            leftMappings.add(values[1])
            mapping[values[0]] = leftMappings.filter { it != "start" }

            val rightMappings = mapping.getOrDefault(values[1], mutableListOf()).toMutableList()
            rightMappings.add(values[0])
            mapping[values[1]] = rightMappings.filter { it != "start" }
        }
    }

    fun findPathsVisitingSmallCaves(): Int {
        mapping["start"]?.forEach { target ->
            currentPath.push("start")
            dfs("start", target) { _, cave -> cave.all { char -> char.isUpperCase() } || cave !in currentPath }
            currentPath.clear()
            visited.clear()
        }

        return paths.size
    }

    fun findPathsVisitingSmallCaves2(): Int {
        mapping.keys.filter { key -> key.all { it.isLowerCase() } && key !in listOf("start", "end") }.forEach { smallCave ->
            mapping["start"]?.forEach { target ->
                currentPath.push("start")
                dfs("start", target) { _, cave -> cave.all { char -> char.isUpperCase() } || cave !in currentPath || (cave == smallCave && currentPath.count { path -> path == smallCave } < 2) }
                currentPath.clear()
                visited.clear()
            }
        }

        return paths.distinct().size
    }

    private fun dfs(source: String, target: String, filter: (current: String, cave: String) -> Boolean) {
        visited.add(target)
        currentPath.push(target)

        val next = Stack<String>()
        if (target != "end") {
            val nextTargets = mapping.getOrDefault(target, emptyList()).filter { filter(target, it) }
            next.addAll(nextTargets)
        } else {
            AdventLogger.debug(currentPath.joinToString(","))
            paths.add(currentPath.toList())
        }

        while(next.isNotEmpty()) {
            dfs(source, next.pop(), filter)
        }

        currentPath.removeLast()
    }
}
