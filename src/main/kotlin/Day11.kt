import util.filterNotEmpty
import java.io.File

class Day11 {
    var grid = File("src/main/resources/day11.txt").readText().parseGrid()
    var flashes = 0

    fun part1(): Int {
        for (c in 0 until 100) {
            var stepFlashes = 0
            for (x in 0 until 10) {
                for (y in 0 until 10) {
                    addAndFlash(x, y)
                }
            }

            for (x in 0 until 10) {
                for (y in 0 until 10) {
                    if (grid[x][y] == 10) {
                        stepFlashes++
                        grid[x][y] = 0
                    }
                }
            }

            flashes += stepFlashes
        }


        return flashes
    }

    fun part2(): Int {
        grid = File("src/main/resources/day11.txt").readText().parseGrid()

        for (c in 0 until Int.MAX_VALUE) {
            var stepFlashes = 0
            for (x in 0 until 10) {
                for (y in 0 until 10) {
                    addAndFlash(x, y)
                }
            }

            for (x in 0 until 10) {
                for (y in 0 until 10) {
                    if (grid[x][y] == 10) {
                        stepFlashes++
                        grid[x][y] = 0
                    }
                }
            }

            if (grid.flatten().count { it == 0 } == 100) {
                return c + 1 // off by one dunno why
            }
        }

        return 0
    }

    private fun addAndFlash(x: Int, y: Int) {
        if (x < 0 || x >= 10 || y < 0 || y >= 10) return

        val value = grid[x][y]

        if (value < 9) {
            grid[x][y] += 1
        } else if (value == 9) {
            grid[x][y] = 10
            getAdjacentPoints(x, y).forEach {
                addAndFlash(it.first, it.second)
            }
        }
    }

    private fun getAdjacentPoints(x: Int, y: Int): List<Pair<Int, Int>> {
        val points: MutableList<Pair<Int, Int>> = mutableListOf()

        for (x0 in -1..1) {
            for (y0 in -1..1) {
                points.add(x + x0 to y + y0)
            }
        }

        return points
    }

    private fun String.parseGrid(): MutableList<MutableList<Int>> {
        return split("\n").map { it.split("").filterNotEmpty().map(String::toInt).toMutableList() }.toMutableList()
    }
 }

fun main() {
    val day11 = Day11()

    println("PART 1\n---")
    println(day11.part1())
    println("PART 2\n---")
    println(day11.part2())
}