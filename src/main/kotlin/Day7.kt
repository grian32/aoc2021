import util.parseToIntList
import java.io.File
import kotlin.math.abs

private val input = File("src/main/resources/day7.txt").readText().parseToIntList()

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    var fuel = Int.MAX_VALUE

    for (i in input.minOrNull()!!..input.maxOrNull()!!) {
        var reqFuel = 0
        for (j in input) {
            reqFuel += abs(j - i)
        }
        if (reqFuel < fuel) {
            fuel = reqFuel
        }
    }

    return fuel
}

private fun part2(): Int {
    var fuel = Int.MAX_VALUE

    for (i in input.minOrNull()!!..input.maxOrNull()!!) {
        var reqFuel = 0
        for (j in input) {
            val distance = abs(j - i)
            reqFuel += distance + (0 until distance).sum()
        }
        if (reqFuel < fuel) {
            fuel = reqFuel
        }
    }

    return fuel
}