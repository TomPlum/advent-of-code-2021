package io.github.tomplum.aoc.message

data class Packet(val data: String) {

    val version = Integer.parseInt(data.take(3), 2)
    val type = if (Integer.parseInt(data.substring(3..5), 2) == 4) PacketType.LITERAL else PacketType.OPERATOR
    val lengthTypeID = data[6].toString().toInt()

    fun getLiteralValue(): Int {
        var remaining = data.substring(6)
        while (remaining.length % 4 != 0) {
            remaining += "0"
        }
        val chunks = remaining.chunked(5).filter { chunk -> !chunk.all { char -> char == '0' } }
        val digits = chunks.joinToString("") { chunk -> chunk.substring(1) }
        return Integer.parseInt(digits, 2)
    }

    fun getSubPacketTotalLength(): Int {
        return Integer.parseInt(data.substring(7..21), 2)
    }

    fun getSubPacketQuantity(): Int {
        return Integer.parseInt(data.substring(7..17), 2)
    }

    fun getSubPackets(): List<Packet> = when(type) {
        PacketType.LITERAL -> {
            val literalValue = getLiteralValue()
            listOf(this)
        }
        else -> {
            when(lengthTypeID) {
                0 -> {
                    val subPacketLength = getSubPacketTotalLength()
                    val subPacketData = data.substring(22, 22 + subPacketLength)
                    Packet(subPacketData).getSubPackets() + this
                }
                1 -> {
                    val subPacketQuantity = getSubPacketQuantity()
                    val subPacketData = data.substring(18).dropLastWhile { value -> value == '0' }
                    subPacketData.chunked(subPacketData.length / subPacketQuantity).flatMap { binary ->
                        Packet(binary).getSubPackets() + this
                    }
                }
                else -> throw IllegalArgumentException("Length Type ID is ${data[6].toString().toInt()} and must be 0 or 1.")
            }
        }
    }
}
