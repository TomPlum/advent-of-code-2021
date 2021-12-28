package io.github.tomplum.aoc.navigation.chiton.strategy

import io.github.tomplum.aoc.navigation.chiton.ChitonCavern

interface CaveGenerationStrategy {
    fun generate(data: List<String>): ChitonCavern
}
