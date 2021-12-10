package io.github.tomplum.aoc.navigation.subsystem

import io.github.tomplum.libs.logging.AdventLogger
import java.util.*

class NavigationSubsystem(private val data: List<String>) {

    private val legalOpeningChars = listOf('(', '[', '{', '<')
    private val legalClosingChars = mutableMapOf(Pair(')', 3), Pair(']', 57), Pair('}', 1197), Pair('>', 25137))
    private val legalPairs = mutableMapOf(Pair('(', ')'), Pair('[', ']'), Pair('{', '}'), Pair('<', '>'))
    private val legalPairs2 = mutableMapOf(Pair(')', '('), Pair(']', '['), Pair('}', '{'), Pair('>', '<'))
    private val completeScoring = mutableMapOf(Pair(')', 1), Pair(']', 2), Pair('}', 3), Pair('>', 4))

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

    fun getMiddlingAutoCompleteScore(): Long {
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

        val incompleteLines = data.filter { line -> line !in corruptLines }
        val newStack = Stack<Char>()
        var scores = mutableListOf<Long>()
        incompleteLines.forEachIndexed { i, line ->
            line.forEach { char ->
                if (char in legalOpeningChars) {
                    newStack.push(char)
                } else {
                    val openingChar = newStack.pop()
                    if (newStack.isEmpty() || char != legalPairs[openingChar]) {
                        AdventLogger.info("Invalid $char on line ${i + 1}")
                        illegalCharacters.add(char)
                        corruptLines.add(line)
                    }
                }
            }

            if (newStack.isNotEmpty()) {
                var score = 0L
                newStack.toList().reversed().forEach { char ->
                    score = (score * 5) + completeScoring.getOrDefault(legalPairs.getOrDefault(char, '-'), 0)
                }
                scores.add(score)
            }

            newStack.clear()
        }

        return scores.sorted()[(scores.size / 2)]
    }
}
