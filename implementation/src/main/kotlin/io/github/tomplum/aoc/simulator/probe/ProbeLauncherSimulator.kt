package io.github.tomplum.aoc.simulator.probe

import java.util.*

class ProbeLauncherSimulator(private val target: String) {

    private val xMin: Int
    private val xMax: Int
    private val yMin: Int
    private val yMax: Int

    init {
        val coords = target.removePrefix("target area: ").split(", ")

        val x = coords[0].removePrefix("x=").split("..")
        xMin = x[0].toInt()
        xMax = x[1].toInt()

        val y = coords[1].removePrefix("y=").split("..")
        yMin = y[0].toInt()
        yMax = y[1].toInt()
    }

    fun calculateMaximumVerticalHeight(): Int {
        val yOrdinates = mutableSetOf<Int>()

        for (xStartVelocity in 1 until 100) {
            for (yStartVelocity in 1 until 100) {

                val yTrajectory = mutableSetOf<Int>()
                var xVelocity = xStartVelocity
                var yVelocity = yStartVelocity

                var x = 0
                var y = 0

                while (!isWithinTargetArea(x, y) && !hasMissedTargetArea(x, y)) {
                    x += xVelocity
                    y += yVelocity
                    xVelocity = if (xVelocity > 0) xVelocity - 1 else if (xVelocity < 0) xVelocity + 1 else 0
                    yVelocity -= 1
                    yTrajectory.add(y)
                }

                if (isWithinTargetArea(x, y)) {
                    yOrdinates.addAll(yTrajectory)
                }
            }
        }

        return yOrdinates.maxOrNull() ?: 0
    }

    private fun isWithinTargetArea(x: Int, y: Int): Boolean {
        return x in xMin..xMax && y >= yMin && y <= yMax
    }

    private fun hasMissedTargetArea(x: Int, y: Int): Boolean {
        return x > xMax || y < yMax
    }
}
