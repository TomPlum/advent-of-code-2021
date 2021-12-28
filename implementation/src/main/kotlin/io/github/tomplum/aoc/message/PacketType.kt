package io.github.tomplum.aoc.message

enum class PacketType {
    SUM, PRODUCT, MIN, MAX, LITERAL_VALUE, GREATER, LESS, EQUAL;

    companion object {
        fun fromInteger(value: Int) = when(value) {
            0 -> SUM
            1 -> PRODUCT
            2 -> MIN
            3 -> MAX
            4 -> LITERAL_VALUE
            5 -> GREATER
            6 -> LESS
            7 -> EQUAL
            else -> throw IllegalArgumentException("Invalid Length Type ID [$value]")
        }
    }
}
