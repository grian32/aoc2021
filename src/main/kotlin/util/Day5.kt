package util
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

object Day5 {
    data class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
        fun allCoordinates(): List<Pair<Int, Int>> {
            // mutable list of x, y pairs
            val coordinates: MutableList<Pair<Int, Int>> = mutableListOf()

            if (x1 == x2) {
                if (y2 > y1) {
                    for (y in y1..y2) {
                        coordinates.add(Pair(x1, y))
                    }
                } else {
                    for (y in y2..y1) {
                        coordinates.add(Pair(x1, y))
                    }
                }
            } else if (y1 == y2) {
                if (x2 > x1) {
                    for (x in x1..x2) {
                        coordinates.add(Pair(x, y1))
                    }
                } else {
                    for (x in x2..x1) {
                        coordinates.add(Pair(x, y1))
                    }
                }
            } else {
                if (abs(y2 - y1) < abs(x2 - x1)) {
                    if (x1 > x2) {
                        coordinates.addAll(plotLineLow(x2, y2, x1, y1))
                    } else {
                        coordinates.addAll(plotLineLow(x1, y1, x2, y2))
                    }
                } else {
                    if (y1 > y2) {
                        coordinates.addAll(plotLineHigh(x2, y2, x1, y1))
                    } else {
                        coordinates.addAll(plotLineHigh(x1, y1, x2, y2))
                    }
                }
            }
            return coordinates
        }

        private fun plotLineLow(x0: Int, y0: Int, x1: Int, y1: Int): List<Pair<Int, Int>> {
            val coordinates: MutableList<Pair<Int, Int>> = mutableListOf()
            val dx = x1 - x0
            var dy = y1 - y0
            var yi = 1
            if (dy < 0) {
                yi = -1
                dy = -dy
            }
            var D = (2 * dy) - dx
            var y = y0

            for (x in x0..x1) {
                coordinates.add(Pair(x, y))
                if (D > 0) {
                    y += yi
                    D += (2 * (dy - dx))
                } else {
                    D += 2 * dy
                }
            }

            return coordinates
        }

        private fun plotLineHigh(x0: Int, y0: Int, x1: Int, y1: Int): List<Pair<Int, Int>> {
            val coordinates: MutableList<Pair<Int, Int>> = mutableListOf()
            var dx = x1 - x0
            val dy = y1 - y0
            var xi = 1
            if (dx < 0) {
                xi = -1
                dx = -dx
            }
            var D = (2 * dx) - dy
            var x = x0

            for (y in y0..y1) {
                coordinates.add(Pair(x, y))

                if (D > 0) {
                    x += xi
                    D += (2 * (dx - dy))
                } else {
                    D += 2 * dx
                }
            }

            return coordinates
        }
    }

    fun parseLineP1(raw: String): Line? {
        // x1,y1 -> x2,y2
        // needs to be horizontal or vertical so filter out the ones that arent
        val parsedRaw = raw.split(" -> ").map { it.split(",") }

        if (parsedRaw[0][0] == parsedRaw[1][0] || parsedRaw[0][1] == parsedRaw[1][1]) {
            return Line(
                parsedRaw[0][0].toInt(),
                parsedRaw[0][1].toInt(),
                parsedRaw[1][0].toInt(),
                parsedRaw[1][1].toInt()
            )
        }

        return null
    }

    fun parseLineP2(raw: String): Line {
        // x1,y1 -> x2,y2
        val parsedRaw = raw.split(" -> ").map { it.split(",") }
        return Line(
            parsedRaw[0][0].toInt(),
            parsedRaw[0][1].toInt(),
            parsedRaw[1][0].toInt(),
            parsedRaw[1][1].toInt()
        )
    }
}