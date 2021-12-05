import util.Day5
import java.io.File

private val input = File("src/main/resources/day5.txt").readText().split("\n")

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val p1input = input.mapNotNull(Day5::parseLineP1)
    val grid: MutableList<MutableList<Int>> = MutableList(999) {
        MutableList(999) {
            0
        }
    }

    for (i in p1input) {
        val coords = i.allCoordinates()

        for (j in coords) {
            val x = j.first
            val y = j.second
            grid[x][y] = grid[x][y] + 1
        }
    }

    return grid.flatten().count { it >= 2}
}

private fun part2(): Int {
    val p2input = input.map(Day5::parseLineP2)
    val grid: MutableList<MutableList<Int>> = MutableList(999) {
        MutableList(999) {
            0
        }
    }

    for (i in p2input) {
        val coords = i.allCoordinates()

        for (j in coords) {
            val x = j.first
            val y = j.second
            grid[x][y] = grid[x][y] + 1
        }
    }

    return grid.flatten().count { it >= 2}
}
