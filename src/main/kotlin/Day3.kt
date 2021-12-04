import util.Day3.leastCommonBitInColumn
import util.Day3.leastCommonBitInColumnP2
import util.Day3.mostCommonBitInColumn
import util.Day3.mostCommonBitInColumnP2
import util.splitIntoColumns
import util.toChar
import java.io.File

private val input = File("src/main/resources/day3.txt").readText()
private const val rowLength = 12

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val columns = input.splitIntoColumns(rowLength)

    var gammaBits = ""
    var epsilonBits = ""

    for (i in columns) {
        gammaBits += mostCommonBitInColumn(i)
        epsilonBits += leastCommonBitInColumn(i)
    }

    return gammaBits.toInt(2) * epsilonBits.toInt(2)
}


private fun part2(): Int {
    var columns = input.splitIntoColumns(rowLength)
    var rows = input.split("\n")

    var oxygenGeneratorBits = ""
    var co2ScrubberBits = ""

    for (i in 0 until rowLength) {
        val mostCommonBit = mostCommonBitInColumnP2(columns[i])
        rows = rows.filter { it[i] == mostCommonBit.toChar() }
        columns = rows.joinToString("\n").splitIntoColumns(rowLength)

        if (rows.size == 1) {
            oxygenGeneratorBits = rows[0]
            break
        }
    }

    columns = input.splitIntoColumns(rowLength)
    rows = input.split("\n")

    for (i in 0 until rowLength) {
        val leastCommonBit = leastCommonBitInColumnP2(columns[i])
        rows = rows.filter { it[i] == leastCommonBit.toChar() }
        columns = rows.joinToString("\n").splitIntoColumns(rowLength)

        if (rows.size == 1) {
            co2ScrubberBits = rows[0]
            break
        }
    }

    return oxygenGeneratorBits.toInt(2) * co2ScrubberBits.toInt(2)
}



