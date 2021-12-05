import util.Day4.BoardItem
import util.Day4.Board
import util.Day4.parseBoard
import util.parseToIntList
import util.randomNumbers
import java.io.File

private val input = File("src/main/resources/day4.txt").readText().split("\n\n")

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val numbers = input[0].parseToIntList()
    val boards: MutableList<Board> = mutableListOf()
    var wonBoard: Board? = null
    var lastNumber: Int? = null

    for (i in 1 until input.size) {
        boards.add(parseBoard(input[i]))
    }

    for (i in numbers) {
        for (board in boards) {
            board.mark(i)

            if (board.hasWon()) {
                wonBoard = board
                lastNumber = i
                break
            }
        }
        if (wonBoard != null) break
    }


    val unmarkedNums = wonBoard!!.rows.flatten().filter { !it.marked }.sumOf { it.num }

    return unmarkedNums * lastNumber!!
}

private fun part2(): Int {
    val numbers = input[0].parseToIntList()
    val boards: MutableList<Board> = mutableListOf()
    // board, number
    var wonBoard: Pair<Board, Int>? = null

    for (i in 1 until input.size) {
        boards.add(parseBoard(input[i]))
    }

    for (i in numbers) {
        val winnerBoards: MutableList<Board> = mutableListOf()
        for (board in boards) {
            board.mark(i)

            if (board.hasWon()) {
                wonBoard = Pair(board, i)
                winnerBoards.add(board)
            }
        }

        for (j in winnerBoards) {
            boards.remove(j)
        }
    }

    val unmarkedNums = wonBoard!!.first.rows.flatten().filter { !it.marked }.sumOf { it.num }

    return unmarkedNums * wonBoard.second
}