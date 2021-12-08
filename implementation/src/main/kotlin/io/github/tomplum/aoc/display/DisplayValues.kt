package io.github.tomplum.aoc.display

enum class DisplayValues(val value: Int, val wires: List<Char>) {
    ZERO(0, listOf('a', 'b', 'c', 'e', 'f', 'g')), //6
    ONE(1, listOf('c', 'f')), //2
    TWO(2, listOf('a', 'c', 'd', 'e', 'g')), //5
    THREE(3, listOf('a', 'c', 'd', 'f', 'g')), //5
    FOUR(4, listOf('b', 'c', 'd', 'f')), //4
    FIVE(5, listOf('a', 'b', 'd', 'f', 'g')), //5
    SIX(6, listOf('a', 'b', 'd', 'e', 'f', 'g')), //6
    SEVEN(7, listOf('a', 'c', 'f')), //3
    EIGHT(8, listOf('a', 'b', 'c', 'd', 'e', 'f', 'g')), //7
    NINE(9, listOf('a', 'b', 'c', 'd', 'f', 'g')); //6

    var mapping: List<Char> = emptyList()

    fun withMapping(mapping: String): DisplayValues {
        this.mapping = mapping.toList()
        return this
    }

    override fun toString(): String {
        return mapping.joinToString("")
    }
}
