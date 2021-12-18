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
        val outermostPacket = Packet(binary)
        val packets = outermostPacket.getSubPackets() + outermostPacket
        return packets.sumOf { packet -> packet.version }
    }

    fun evaluateExpressionValue(): Int {
        val binary = transmission.map { char -> binaryMapping[char] }.joinToString("")
        val outermostPacket = Packet(binary)
        val packets = outermostPacket.getSubPackets()
        return 0
    }
}
