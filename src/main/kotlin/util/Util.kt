package util

fun String.splitIntoColumns(rowLength: Int): List<String> {
    val rows = split("\n").map { it.split("").filter { char -> char != "" } }
    val columns: MutableList<MutableList<String>> = mutableListOf()

    for (i in 0 until rowLength) {
        columns.add(mutableListOf())
    }

    for (i in rows) {
        for (j in 0 until rowLength) {
            columns[j].add(i[j])
        }
    }

    return columns.map { it.joinToString("") }.toList()
}

fun String.toChar(): Char {
    if (length > 1 || length < 1) {
        throw IllegalArgumentException("Cannot convert a string longer or shorter than 1 to a Char")
    }

    return get(0)
}

// assumes format is similar to 0.0,0,0,0,
fun String.parseToIntList(): List<Int> = trim().split(",").map(String::trim).map(String::toInt)

fun List<String>.filterNotEmpty(): List<String> = filter { it != "" }

fun List<Int>.randomNumbers(amount: Int): List<Int> {
    val randomNums: MutableList<Int> = mutableListOf()

    for (i in 0 until amount) {
        randomNums.add(random())
    }

    return randomNums.toList()
}

fun List<Long>.middle(): Long {
    return slice(0..(size / 2)).last()
}