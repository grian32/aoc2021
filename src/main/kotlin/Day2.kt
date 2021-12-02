import java.io.File

private val input = File("src/main/resources/day2.txt").readText().split("\n")

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val p1input = input.map { it.split(" ") }

    var horizontal = 0
    var depth = 0

    for ((command, input) in p1input) {
        when (command) {
            "forward" -> horizontal += input.toInt()
            "down" -> depth += input.toInt()
            "up" -> depth -= input.toInt()
        }
    }

    return horizontal * depth
}

private fun part2(): Int {
    val p2input = input.map { it.split(" ") }

    var horizontal = 0
    var depth = 0
    var aim = 0

    for ((command, input) in p2input) {
        when (command) {
            "down" -> aim += input.toInt()
            "up" -> aim -= input.toInt()
            "forward" -> {
                horizontal += input.toInt()
                depth += aim * input.toInt()
            }
        }
    }

    return horizontal * depth
}