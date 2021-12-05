package util

object Day4 {

    data class BoardItem(val num: Int, var marked: Boolean)

    data class Board(var rows: List<List<BoardItem>>) {
        private fun getColumns(): List<List<BoardItem>> {
            val columns: MutableList<MutableList<BoardItem>> = mutableListOf()

            for (i in 0 until 5) {
                columns.add(mutableListOf())
            }

            for (i in rows) {
                for (j in 0 until 5) {
                    columns[j].add(i[j])
                }
            }

            return columns
        }

        fun hasWon(): Boolean {
            for (i in rows) {
                if (i.all { it.marked }) {
                    return true
                }
            }

            for (i in getColumns()) {
                if (i.all { it.marked }) {
                    return true
                }
            }

            return false
        }

        fun mark(number: Int) {
            for (i in rows) {
                for (j in i) {
                    if (j.num == number) {
                         j.marked = true
                    }
                }
            }
        }
    }

    fun parseBoard(raw: String): Board {
        // format
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        val rawRows = raw.split("\n").map { it.split(" ").filterNotEmpty().map(String::toInt) }
        val rows: MutableList<List<BoardItem>> = mutableListOf()

        for (i in rawRows) {
            val list = mutableListOf<BoardItem>()
            for (j in i) {
                list.add(BoardItem(j, false))
            }
            rows.add(list.toList())
        }

        return Board(rows.toList())
    }
}