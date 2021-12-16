package io.github.tomplum.aoc.message

class PacketDecoder(private val transmission: String) {

    private val binaryMapping = mutableMapOf(
        Pair('0', "0000"),
        Pair('1', "0001"),
        Pair('2', "0010"),
        Pair('3', "0011"),
        Pair('4', "0100"),
        Pair('5', "0101"),
        Pair('6', "0110"),
        Pair('7', "0111"),
        Pair('8', "1000"),
        Pair('9', "1001"),
        Pair('A', "1010"),
        Pair('B', "1011"),
        Pair('C', "1100"),
        Pair('D', "1101"),
        Pair('E', "1110"),
        Pair('F', "1111")
    )

    fun calculatePacketVersionNumberSum(): Int {
        val binary = transmission.map { char -> binaryMapping[char] }.joinToString("")
        val packetVersion = Integer.parseInt(binary.take(3), 2)
        val typeID = Integer.parseInt(binary.substring(3..5), 2)
        val packets = mutableListOf<String>()
        when(typeID) {
            4 -> {
                // Literal Value
                var remaining = binary.substring(6)
                while (remaining.length % 4 != 0) {
                    remaining += "0"
                }
                val chunks = remaining.chunked(5).filter { chunk -> !chunk.all { char -> char == '0' } }
                val digits = chunks.joinToString("") { chunk -> chunk.substring(1) }
                val number = Integer.parseInt(digits, 2)
            }
            else -> {
                // Operator
                val lengthTypeID = binary[6].toString().toInt()
                when(lengthTypeID) {
                    0 -> {
                        val subPacketLength = Integer.parseInt(binary.substring(7..23), 2)
                    }
                    1 -> {
                        val subPacketQuantity = Integer.parseInt(binary.substring(7..19), 2)
                        var i = 7

                        repeat(subPacketQuantity) {
                            binary.substring(i + 11)
                            i += 11
                        }
                    }
                    else -> throw IllegalArgumentException("Length Type ID is $lengthTypeID and must be 0 or 1.")
                }
            }
        }
        return 0
    }

    fun parseOperatorPacket(packet: String) {

    }
}
