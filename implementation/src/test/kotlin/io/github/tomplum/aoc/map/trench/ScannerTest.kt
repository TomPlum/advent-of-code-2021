package io.github.tomplum.aoc.map.trench

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class ScannerTest {
    @Test
    fun partOneExampleOne() {
        val input = TestInputReader.read<String>("/day20/example.txt").value
        val scanner = Scanner(input)
        assertThat(scanner.enhanceImage(2)).isEqualTo(35)
    }
}
