package io.github.tomplum.aoc.message

enum class LengthType {
    TOTAL_BIT_LENGTH, SUB_PACKET_QUANTITY;

    companion object {
        fun fromValue(value: Int) = when(value) {
            0 -> TOTAL_BIT_LENGTH
            1 -> SUB_PACKET_QUANTITY
            else -> throw IllegalArgumentException("Invalid Length Type ID [$value]")
        }
    }
}
