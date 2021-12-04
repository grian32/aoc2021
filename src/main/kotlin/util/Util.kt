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