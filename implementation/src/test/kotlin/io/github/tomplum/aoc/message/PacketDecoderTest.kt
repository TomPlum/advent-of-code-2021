package io.github.tomplum.aoc.message

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class PacketDecoderTest {
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

    @Test
    fun partTwoExampleOne() {
        val decoder = PacketDecoder("C200B40A82")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(3)
    }

    @Test
    fun partTwoExampleTwo() {
        val decoder = PacketDecoder("04005AC33890")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(54)
    }

    @Test
    fun partTwoExampleThree() {
        val decoder = PacketDecoder("880086C3E88112")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(7)
    }

    @Test
    fun partTwoExampleFour() {
        val decoder = PacketDecoder("CE00C43D881120")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(9)
    }

    @Test
    fun partTwoExampleFive() {
        val decoder = PacketDecoder("D8005AC2A8F0")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(1)
    }

    @Test
    fun partTwoExampleSix() {
        val decoder = PacketDecoder("F600BC2D8F")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(0)
    }

    @Test
    fun partTwoExampleSeven() {
        val decoder = PacketDecoder("9C005AC2F8F0")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(0)
    }

    @Test
    fun partTwoExampleEight() {
        val decoder = PacketDecoder("9C0141080250320F1802104A08")
        val expressionValue = decoder.evaluateExpressionValue()
        assertThat(expressionValue).isEqualTo(1)
    }
}
