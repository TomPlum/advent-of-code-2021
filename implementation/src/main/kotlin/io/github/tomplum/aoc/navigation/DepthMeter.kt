package io.github.tomplum.aoc.navigation


class DepthMeter(val course: List<String>) {
    fun calculateCourseDestination(): PositionReport {
        val directives = course.map { entry ->
            val values = entry.split(" ")
            when(values[0]) {
                "forward" ->  Directive(Direction.FORWARD, values[1].toInt())
                "down" ->  Directive(Direction.DOWN, values[1].toInt())
                "up" ->  Directive(Direction.UP, values[1].toInt())
                else -> throw IllegalArgumentException("Invalid Direction [$${values[0]}]")
            }
        }

        var horizontal = 0
        var depth = 0

        directives.forEach { directive ->
            when(directive.direction) {
                Direction.FORWARD -> horizontal += directive.distance
                Direction.DOWN -> depth += directive.distance
                Direction.UP -> depth -= directive.distance
            }
        }

        return PositionReport(horizontal, depth)
    }
    fun calculateCourseDestination2(): PositionReport {
        val directives = course.map { entry ->
            val values = entry.split(" ")
            when(values[0]) {
                "forward" ->  Directive(Direction.FORWARD, values[1].toInt())
                "down" ->  Directive(Direction.DOWN, values[1].toInt())
                "up" ->  Directive(Direction.UP, values[1].toInt())
                else -> throw IllegalArgumentException("Invalid Direction [$${values[0]}]")
            }
        }

        var horizontal = 0
        var depth = 0
        var aim = 0

        directives.forEach { directive ->
            when(directive.direction) {
                Direction.FORWARD -> {
                    horizontal += directive.distance
                    depth += aim * directive.distance
                }
                Direction.DOWN -> aim += directive.distance
                Direction.UP -> aim -= directive.distance
            }
        }

        return PositionReport(horizontal, depth)
    }

}
