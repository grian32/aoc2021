import java.io.File
import util.Day11.parseIntoGrid

//private val input = File("src/main/resources/day11.txt").readText()
private val input = """5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526"""

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    var flashes = 0
    val grid = parseIntoGrid(input)
    for (i in 0..100) {
        for ((x, i) in grid.rows.withIndex()) {
            for ((y, j) in i.withIndex()) {
                grid[x, y] += 1
            }
        }

        for ((x, i) in grid.rows.withIndex()) {
            for ((y, j) in i.withIndex()) {
                if (grid[x, y] >= 9) {
                   flashes += grid.flash(x, y)
                }
            }
        }

        for ((x, i) in grid.rows.withIndex()) {
            for ((y, j) in i.withIndex()) {
                if (grid[x, y] >= 9) {
                    grid[x, y] = 0
                }
            }
        }
    }

    return flashes
}

private fun part2(): Int {

    return 0
}
