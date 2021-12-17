package io.github.tomplum.aoc.simulator.probe

import io.github.tomplum.libs.math.point.Point2D

class ProbeLauncherSimulator(target: String) {

    private val xMin: Int
    private val xMax: Int
    private val yMin: Int
    private val yMax: Int

    private val yOrdinates = mutableSetOf<Int>()
    private val validStartingVelocity = mutableSetOf<Point2D>()

    init {
        val coords = target.removePrefix("target area: ").split(", ")

        val xArea = coords[0].removePrefix("x=").split("..")
        xMin = xArea[0].toInt()
        xMax = xArea[1].toInt()

        val yArea = coords[1].removePrefix("y=").split("..")
        yMin = yArea[0].toInt()
        yMax = yArea[1].toInt()

        for (xStartVelocity in 1 until 1000) {
            for (yStartVelocity in -100 until 1000) {

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
                    validStartingVelocity.add(Point2D(xStartVelocity, yStartVelocity))
                }
            }
        }
    }

    fun calculateMaximumVerticalHeight(): Int {
        return yOrdinates.maxOrNull() ?: 0
    }

    fun calculateTotalDistinctInitialVelocityValues(): Set<Point2D> {
        return validStartingVelocity
    }

    private fun isWithinTargetArea(x: Int, y: Int): Boolean {
        return x in xMin..xMax && y >= yMin && y <= yMax
    }

    private fun hasMissedTargetArea(x: Int, y: Int): Boolean {
        return x > xMax || y < yMin
    }
}
