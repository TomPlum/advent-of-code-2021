package io.github.tomplum.aoc.map.trench

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class ImageEnhancerTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day20/example.txt").value
        val imageEnhancer = ImageEnhancer(input)
        assertThat(imageEnhancer.applyEnhancementAlgorithm(2)).isEqualTo(35)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day20/example.txt").value
        val imageEnhancer = ImageEnhancer(input)
        assertThat(imageEnhancer.applyEnhancementAlgorithm(50)).isEqualTo(3351)
    }
}
