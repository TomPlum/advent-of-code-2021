package io.github.tomplum.aoc.display

enum class DisplayValues(val value: Int, val wires: List<Char>) {
    ZERO(0, listOf('a','b','c','e','f', 'g')),
    ONE(1, listOf('c', 'f')),
    TWO(2, listOf('a', 'c', 'd', 'e', 'g')),
    THREE(3, listOf('a', 'c', 'd', 'f', 'g')),
    FOUR(4, listOf('b', 'c', 'd', 'f')),
    FIVE(5, listOf('a', 'b', 'd', 'f', 'g')),
    SIX(6, listOf('a', 'b', 'd', 'e', 'f', 'g')),
    SEVEN(7, listOf('a', 'c', 'f')),
    EIGHT(8, listOf('a','b','c', 'd', 'e','f', 'g')),
    NINE(9, listOf('a','b','c', 'd','f', 'g'))
}
