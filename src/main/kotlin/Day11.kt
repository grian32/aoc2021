import util.filterNotEmpty
import java.io.File

class Day11 {
    var grid = File("src/main/resources/day11.txt").readText().parseGrid()
    var flashes = 0

    fun part1(): Int {
        for (c in 0 until 100) {
            step()
        }

        return flashes
    }

    fun part2(): Int {
        grid = File("src/main/resources/day11.txt").readText().parseGrid()

        for (c in 1 until Int.MAX_VALUE) {
            step()

            if (grid.flatten().count { it == 0 } == 100) {
                return c
            }
        }

        return 0
    }

    private fun step() {
        var stepFlashes = 0

        for ((x, i) in grid.withIndex()) {
            for (y in i.indices) {
                if (grid[x][y] < 9) {
                    grid[x][y]++
                } else if (grid[x][y] == 9) {
                    flash(x, y, true)
                }
            }
        }

        for ((x, i) in grid.withIndex()) {
            for (y in i.indices) {
                if (grid[x][y] == 10) {
                    grid[x][y] = 0
                    stepFlashes++
                }
            }
        }

        flashes += stepFlashes
    }

    private fun flash(x: Int, y: Int, first: Boolean = false) {
        if (x < 0 || y < 0 || x >= grid.size || y >= grid[0].size) return

        if (grid[x][y] < 9 && !first) {
            grid[x][y]++
        } else if (grid[x][y] == 9){
            grid[x][y] = 10
            getAdjacentPoints(x, y).forEach {
                flash(it.first, it.second)
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