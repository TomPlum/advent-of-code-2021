package io.github.tomplum.aoc.map.trench

class Scanner(data: List<String>) {

    private val imageEnhancer: ImageEnhancer

    init {
        val trenchMap = TrenchMap(data.takeLastWhile { line -> line != "" })
        imageEnhancer = ImageEnhancer(data.takeWhile { line -> line != "" }.joinToString(""), trenchMap)
    }

    fun enhanceImage(iterations: Int): Int {
        return imageEnhancer.applyEnhancementAlgorithm(iterations)
    }
}
