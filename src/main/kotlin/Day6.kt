import util.parseToIntList
import java.io.File

private val input = File("src/main/resources/day6.txt").readText().parseToIntList()

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val newList: MutableList<Int> = input.toMutableList()

    for (i in 0 until 80) {
        for (j in 0 until newList.size) {
            if (newList[j] == 0) {
                newList[j] = 6
                newList.add(8)
                continue
            }

            newList[j] = newList[j] - 1
        }
    }

    return newList.size
}

private fun part2(): Long {
    val newList: MutableList<Long> = MutableList(9) {
        0
    }

    for (i in input) {
        newList[i] = newList[i] + 1
    }

    for (i in 0 until 256) {
        val old1Num = newList[1]
        newList[1] = newList[2]
        newList[2] = newList[3]
        newList[3] = newList[4]
        newList[4] = newList[5]
        newList[5] = newList[6]
        newList[6] = newList[7] + newList[0]
        newList[7] = newList[8]
        newList[8] = newList[0]
        newList[0] = old1Num
    }

    return newList.sum()
}