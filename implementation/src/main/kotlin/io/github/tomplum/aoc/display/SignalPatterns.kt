package io.github.tomplum.aoc.display

data class SignalPatterns(val value: List<String>) {
    fun findPatternWithSameLengthAs(number: DisplayValues) = value.find { pattern ->
        number.matchesLength(pattern)
    } ?: throw IllegalArgumentException("None of[$value] match length of ${number.value}")

    fun getPatternsWithLength(length: Int) = value.filter { pattern -> pattern.length == length }
}
