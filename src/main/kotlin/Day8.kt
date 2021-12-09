import java.io.File

//private val input = File("src/main/resources/day8.txt").readText().split("\n")
private val input = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf".split("\n")

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    /**
     * 7 is length 3
     * 4 is length 4
     * 1 is length 2
     * 8 is length 7
     */
    val p1input = input.map { it.split(" | ")[1].split(" ") }.flatten()
    var amount = 0

    for (i in p1input) {
        when (i.length) {
            3, 4, 2, 7 -> amount++
        }
    }

    return amount
}

private fun part2(): Int {
    val p2input = input.map {
        val splitVal = it.split(" | ").map { s -> s.split(" ") }

        return@map Pair(splitVal[0], splitVal[1])
    }

    for (i in p2input) {
        val signals = i.first
        /**
         * 7 is length 3
         * 4 is length 4
         * 1 is length 2
         * 8 is length 7
         */
        val segments = mutableMapOf(
            1 to "",
            2 to "",
            3 to "",
            4 to "",
            5 to "",
            6 to "",
            7 to "",
            8 to "",
            9 to ""
        )


        for (j in signals) {
            when (j.length) {
                3 -> segments[7] = j
                4 -> segments[4] = j
                2 -> segments[1] = j
                7 -> segments[8] = j
            }
        }
    }

    return 0
}