package io.github.tomplum.aoc.camera

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.aoc.input.TestInputReader
import org.junit.jupiter.api.Test

class ThermalCameraTest {
    @Test
    fun examplePartOne() {
        val input = TestInputReader.read<String>("/day13/example.txt")
        val camera = ThermalCamera(input.value)
        assertThat(camera.countVisibleDots()).isEqualTo(17)
    }
}
