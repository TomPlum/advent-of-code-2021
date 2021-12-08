package io.github.tomplum.aoc.display

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class DisplayAnalyserTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day8/larger-example.txt")
        val analyser = DisplayAnalyser(input.value)
        assertThat(analyser.countUniqueSegmentsInstances()).isEqualTo(26)
    }

    @Test
    fun smallerExamplePartTwo() {
        val input = TestInputReader.read<String>("/day8/example.txt")
        val analyser = DisplayAnalyser(input.value)
        assertThat(analyser.getOutputValueSum()).isEqualTo(5353)
    }

    @Test
    fun largerExamplePartTwo() {
        val input = TestInputReader.read<String>("/day8/larger-example.txt")
        val analyser = DisplayAnalyser(input.value)
        assertThat(analyser.getOutputValueSum()).isEqualTo(61229)
    }
}
