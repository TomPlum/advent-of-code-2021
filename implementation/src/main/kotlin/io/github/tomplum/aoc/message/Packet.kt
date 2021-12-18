package io.github.tomplum.aoc.message

import io.github.tomplum.aoc.message.LengthType.*
import io.github.tomplum.aoc.message.PacketType.*
import java.util.*

data class Packet(val data: String) {

    val id = UUID.randomUUID()
    val version = Integer.parseInt(data.take(3), 2)
    val type = if (Integer.parseInt(data.substring(3..5), 2) == 4) LITERAL else OPERATOR
    val lengthType = LengthType.fromInteger(data[6].toString().toInt())
    var literalValue: Int? = null

    fun getSubPackets(): List<Packet> = when(type) {
        LITERAL -> {
            /*var padded = data.substring(6)
            while (padded.length % 4 != 0) {
                padded += "0"
            }*/
            val chunks = data.substring(6).chunked(5) //.filter { chunk -> !chunk.all { char -> char == '0' } }
            val valueChunks = chunks.takeWhile { chunk -> chunk.first() == '1' }.toMutableList()
            if (valueChunks.isEmpty()) {
                valueChunks.add(chunks.first())
            } else {
                valueChunks.add(chunks[valueChunks.size])
            }
            val digits = valueChunks.joinToString("") { chunk -> chunk.substring(1) }
            //literalValue = Integer.parseInt(digits, 2)

            val potentialPacketData = data.substring(7 + valueChunks.joinToString("").length - 1)
            if (!potentialPacketData.all { char -> char == '0' }) {
                listOf(this) + Packet(potentialPacketData).getSubPackets()
            } else {
                listOf(this)
            }
        }
        OPERATOR -> {
            when(lengthType) {
                SUM -> {
                    val subPacketLength = Integer.parseInt(data.substring(7..21), 2)
                    val subPacketData = data.substring(22, 22 + subPacketLength)
                    val otherPacketData = data.substring(22 + subPacketLength).dropLastWhile { it == '0' }
                    if (otherPacketData.isNotBlank()) {
                        Packet(subPacketData).getSubPackets() + Packet(otherPacketData).getSubPackets() + this
                    } else {
                        Packet(subPacketData).getSubPackets() + this
                    }
                }
                PRODUCT -> {
                    val subPacketQuantity = Integer.parseInt(data.substring(8..17), 2)
                    val subPacketData = data.substring(18).dropLastWhile { value -> value == '0' }
                   /* subPacketData.dropLastWhile { value -> value == '0' }.chunked(subPacketData.length / subPacketQuantity).flatMap { binary ->
                        Packet(binary).getSubPackets() + this
                    }*/
                    Packet(subPacketData).getSubPackets() + this
                }
                else -> emptyList()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Packet

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}
