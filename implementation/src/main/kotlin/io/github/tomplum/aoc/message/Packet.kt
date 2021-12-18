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
    val children = mutableListOf<Packet>()

/*    fun calculateValue() = when(lengthType) {
        SUM -> {

        }
    }*/

    init {
        when(type) {
            LITERAL -> {
                val chunks = data.substring(6).chunked(5)
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
                    children.add(Packet(potentialPacketData))
                }
            }
            OPERATOR -> {
                when(lengthType) {
                    SUM -> {
                        val subPacketLength = Integer.parseInt(data.substring(7..21), 2)
                        val subPacketData = data.substring(22, 22 + subPacketLength)
                        val otherPacketData = data.substring(22 + subPacketLength).dropLastWhile { it == '0' }
                        if (otherPacketData.isNotBlank()) {
                            children.addAll(listOf(Packet(subPacketData), Packet(otherPacketData)))
                        } else {
                            children.add(Packet(subPacketData))
                        }
                    }
                    PRODUCT -> {
                        val subPacketData = data.substring(18).dropLastWhile { value -> value == '0' }
                        children.add(Packet(subPacketData))
                    }
                }
            }
        }
    }

    fun getSubPackets(): List<Packet> {
        return children + children.flatMap { packet -> packet.getSubPackets() }
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
