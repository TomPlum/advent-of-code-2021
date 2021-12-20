package io.github.tomplum.aoc.map.trench

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class ScannerTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day20/example.txt").value
        val scanner = Scanner(input)
        assertThat(scanner.enhanceImage(2)).isEqualTo(35)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day20/example.txt").value
        val scanner = Scanner(input)
        assertThat(scanner.enhanceImage(50)).isEqualTo(3351)
    }
}
