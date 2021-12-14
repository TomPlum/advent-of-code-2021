package io.github.tomplum.aoc.polymer

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class PolymeriserTest {
    @Test
    fun partOneExample() {
        val input = TestInputReader.read<String>("/day14/example.txt")
        val polymeriser = Polymeriser(input.value)
        assertThat(polymeriser.doThing(10)).isEqualTo(1588)
    }

    @Test
    fun partTwoExample() {
        val input = TestInputReader.read<String>("/day14/example.txt")
        val polymeriser = Polymeriser(input.value)
        assertThat(polymeriser.doThing(40)).isEqualTo(2188189693529)
    }
}
