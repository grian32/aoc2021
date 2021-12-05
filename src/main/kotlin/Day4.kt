import util.Day4.BoardItem
import util.Day4.Board
import util.Day4.parseBoard
import util.parseToIntList
import util.randomNumbers
import java.io.File

private val input = File("src/main/resources/day4.txt").readText()

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val p1input = input.split("\n\n")

    val rollNumbers = p1input[0].parseToIntList()
    val boards: MutableList<Board> = mutableListOf()
    var numbersAmount = 5
    var wonBoard: Board? = null
    var lastItem: BoardItem? = null

    for (i in 1 until p1input.size) {
        boards.add(parseBoard(p1input[i]))
    }

    var rolledNumbers = rollNumbers.randomNumbers(numbersAmount)

    while (wonBoard == null) {
        for (i in boards) {
            for (j in i.rows) {
                for (k in j) {
                    if (k.num in rolledNumbers) {
                        k.marked = true
                    }

                    if (i.hasWon()) {
                        lastItem = k
                        wonBoard = i
                        break
                    }
                }
                if (wonBoard != null) break
            }
            if (wonBoard != null) break
        }
        numbersAmount++
        rolledNumbers = rollNumbers.randomNumbers(numbersAmount)
    }

    val unmarkedNums = wonBoard.rows.flatten().filter { !it.marked }.sumOf { it.num }

    return unmarkedNums * lastItem!!.num
}

private fun part2() {

}