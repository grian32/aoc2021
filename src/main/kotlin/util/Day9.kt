package util

object Day9 {
    data class Grid(val rows: MutableList<MutableList<Int>>) {
        fun isLowPoint(x: Int, y: Int): Boolean {
            val num = this[x, y]

            val top = this[x, y - 1]
            val bottom = this[x, y + 1]
            val left = this[x - 1, y]
            val right = this[x + 1, y]

            if (top > num && bottom > num && left > num && right > num) {
                return true
            }

            return false
        }

        operator fun get(x: Int, y: Int): Int {
            if (x < 0 || y < 0 || x >= rows.size || y >= rows[0].size) {
                return 123
            }

            return rows[x][y]
        }

        operator fun set(x: Int, y: Int, value: Int) {
            rows[x][y] = value
        }


        fun basinSize(x: Int, y: Int): Int {
            if (!(x < 0 || y < 0 || x >= rows.size || y >= rows[0].size || this[x, y] == 9)) {
                var size = 0
                this[x, y] = 9

                size += basinSize(x, y - 1)
                size += basinSize(x, y + 1)
                size += basinSize(x - 1, y)
                size += basinSize(x + 1, y)

                return size + 1
            }

            return 0
        }
    }

    fun parseIntoGrid(raw: String): Grid {
        val rows = raw.split("\n").map { it.split("").filterNotEmpty().map { s -> s.toInt() } }

        return Grid(rows.map { it.toMutableList() }.toMutableList())
    }
}
