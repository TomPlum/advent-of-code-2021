package io.github.tomplum.aoc.fish.snail

data class SnailFishNumber(val value: String) {

    init {
        val brackets = mutableListOf<Char>()
        var currentPairFirst: Int = 0
        var currentPairSecond: Int = 0
        var currentPair: Pair<Int, Int>
        var hasSetFirstPairValue = false
        var hasClosedCurrentPair = false
        var openPairs = 0
        value.forEach { char ->
            if (char.isDigit()) {
                val digit = char.toString().toInt()

                if (!hasSetFirstPairValue) {
                    currentPairFirst = digit
                    hasSetFirstPairValue = true
                } else {
                    currentPairSecond = digit
                }
            }

            if (char =='[') {
                openPairs++
            }

            if (char == ']') {
                openPairs--
                currentPair = Pair(currentPairFirst, currentPairSecond)
                hasClosedCurrentPair = true
            }

            if (char == ',' && hasClosedCurrentPair) {

            }
        }
    }

    fun reduce(): SnailFishNumber {
        var startIndex = value.indexOf(']') - 4
        val leftNumber = value[startIndex + 1]
        if (value.substring(0, startIndex).count { it == '[' } == 4 || value.substring(startIndex + 5).count { it == ']' } == 4) {

        }
        return SnailFishNumber("")
    }
}
