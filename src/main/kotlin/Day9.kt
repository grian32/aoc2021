import util.Day9.parseIntoGrid
import java.io.File

private val input = File("src/main/resources/day9.txt").readText()

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val grid = parseIntoGrid(input)
    var riskSum = 0

    for ((x, i) in grid.rows.withIndex()) {
        for ((y, j) in i.withIndex()) {
            if (grid.isLowPoint(x, y)) {
                riskSum += j + 1
            }
        }
    }

    return riskSum
}

private fun part2(): Int {
    val grid = parseIntoGrid(input)
    val basinSizes: MutableList<Int> = mutableListOf()

    for ((x, i) in grid.rows.withIndex()) {
        for ((y, j) in i.withIndex()) {
            if (grid.isLowPoint(x, y)) {
                basinSizes.add(grid.basinSize(x, y))
            }
        }
    }

    return basinSizes.sorted().takeLast(3).reduce(Int::times)
}