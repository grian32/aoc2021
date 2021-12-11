import util.middle
import java.io.File

private val input = File("src/main/resources/day10.txt").readText().split("\n")

fun main() {
    println("PART 1\n---")
    println(part1())
    println("PART 2\n---")
    println(part2())
}

private fun part1(): Int {
    val mappings = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']',
        '<' to '>'
    )
    val scores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )
    var score = 0

    val list: MutableList<Char> = mutableListOf()

    for (i in input) {
        for (j in i) {
            if (j in mappings) {
                list.add(mappings[j]!!)
            } else if (list.removeLast() != j) {
                score += scores[j]!!
            }
        }
    }

    return score
}

private fun part2(): Long {
    val mappings = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']',
        '<' to '>'
    )
    val completionScores = mapOf(
        ')' to 1L,
        ']' to 2L,
        '}' to 3L,
        '>' to 4L
    )
    val corruptScores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )

    val scores: MutableList<Long> = mutableListOf()

    val incompleteParens: MutableList<List<Char>> = mutableListOf()

    for (i in input) {
        var corrupted = false
        val list: MutableList<Char> = mutableListOf()

        for (j in i) {
            if (j in mappings) {
                list.add(mappings[j]!!)
            } else if (list.removeLast() != j) {
                corrupted = true
                continue
            }
        }

        if (!corrupted) {
            incompleteParens.add(list.reversed())
        }
    }

    for (i in incompleteParens.toSet()) {
        var score = 0L
        for (j in i) {
            if (j in completionScores) {
                score = score * 5 + completionScores[j]!!
            }
        }
        scores.add(score)
    }

    return scores.sorted().middle()
}