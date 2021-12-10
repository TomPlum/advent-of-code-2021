package io.github.tomplum.aoc.navigation.subsystem

import io.github.tomplum.libs.logging.AdventLogger
import java.util.*

class NavigationSubsystem(private val data: List<String>) {

    private val legalOpeningChars = listOf('(', '[', '{', '<')
    private val legalClosingChars = mutableMapOf(Pair(')', 3), Pair(']', 57), Pair('}', 1197), Pair('>', 25137))
    private val legalPairs = mutableMapOf(Pair('(', ')'), Pair('[', ']'), Pair('{', '}'), Pair('<', '>'))

    fun getTotalSyntaxErrorScore(): Int {
        val stack = Stack<Char>()
        val corruptLines = mutableListOf<String>()
        val illegalCharacters = mutableListOf<Char>()
        data.forEachIndexed { i, line ->
            line.forEach { char ->
                if (!corruptLines.contains(line)) {
                    if (char in legalOpeningChars) {
                        stack.push(char)
                    } else {
                        val openingChar = stack.pop()
                        if (stack.isEmpty() || char != legalPairs[openingChar]) {
                            AdventLogger.info("Invalid $char on line ${i + 1}")
                            illegalCharacters.add(char)
                            corruptLines.add(line)
                        }
                    }
                }
            }
        }
        AdventLogger.debug("These lines were corrupt:")
        corruptLines.forEach { line -> AdventLogger.debug(line) }
        return illegalCharacters.sumOf { char -> legalClosingChars.getOrDefault(char, 0) }
    }
}
