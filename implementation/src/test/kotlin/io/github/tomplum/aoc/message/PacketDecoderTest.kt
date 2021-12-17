package io.github.tomplum.aoc.message

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class PacketDecoderTest {
    @Test
    fun example() {
        val decoder = PacketDecoder("D2FE28")
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(16)
    }

    @Test
    fun operatorLengthTypeID1() {
        val decoder = PacketDecoder("EE00D40C823060")
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(16)
    }

    @Test
    fun operatorLengthTypeID0() {
        val decoder = PacketDecoder("38006F45291200")
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(16)
    }

    @Test
    fun partOneExampleOne() {
        val input = TestInputReader.read<String>("/day16/example-1.txt").asSingleString()
        val decoder = PacketDecoder(input)
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(16)
    }

    @Test
    fun partOneExampleTwo() {
        val input = TestInputReader.read<String>("/day16/example-2.txt").asSingleString()
        val decoder = PacketDecoder(input)
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(12)
    }

    @Test
    fun partOneExampleThree() {
        val input = TestInputReader.read<String>("/day16/example-3.txt").asSingleString()
        val decoder = PacketDecoder(input)
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(23)
    }

    @Test
    fun partOneExampleFour() {
        val input = TestInputReader.read<String>("/day16/example-4.txt").asSingleString()
        val decoder = PacketDecoder(input)
        assertThat(decoder.calculatePacketVersionNumberSum()).isEqualTo(31)
    }
}
