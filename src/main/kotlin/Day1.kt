import java.io.File
import kotlin.math.max

val input = File("src/main/resources/day1.txt").readText().split("\n").map(String::toInt)

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val p1input = input.chunked(2)
    val p1input2 = input.slice(1 until input.size - 1).chunked(2)
    var increases = 0

    for (i in p1input) {
        if (max(i[0], i[1]) == i[1]) increases++
    }

    for (i in p1input2) {
        if (max(i[0], i[1]) == i[1]) increases++
    }

    return increases
}

private fun part2(): Int {
    val p2input = input.windowed(3).map { it.sum() }.zipWithNext()

    var increases = 0

    for (i in p2input) {
        if (i.first < i.second) {
            increases++
        }
    }

    return increases
}