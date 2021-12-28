package io.github.tomplum.aoc.fish.snail

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.fish.snail.SnailFishHomework
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class SnailFishHomeworkTest {
    @Test
    fun exampleOne() {
        val input = TestInputReader.read<String>("/day18/example.txt").value
        val homework = SnailFishHomework(input)
        assertThat(homework.calculateFinalSumMagnitude()).isEqualTo(4140)
    }
}

