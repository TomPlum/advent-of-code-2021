package io.github.tomplum.aoc.fish.snail

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SnailFishNumberTest {
    @Test
    fun singleExplodeAction1() {
        val number = SnailFishNumber("[[[[[9,8],1],2],3],4]")
        val reduced = number.reduce()
        assertThat(reduced.value).isEqualTo("[[[[0,9],2],3],4]")
    }
}
