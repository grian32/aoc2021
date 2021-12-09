package util

object Day9 {
    data class Grid(val rows: List<List<Int>>) {
        fun isLowPoint(x: Int, y: Int): Boolean {
            val num = this[x, y]
            val top = rows.getOrNull(x)?.getOrNull(y + 1)
            val bottom = rows.getOrNull(x)?.getOrNull(y - 1)
            val left = rows.getOrNull(x - 1)?.getOrNull(y)
            val right = rows.getOrNull(x + 1)?.getOrNull(y)

            // top left corner
            if ((top == null && left == null) && (bottom > num && right > num)) {
                return true
            }
            // top edge
            if ((top == null) && (bottom > num && right > num && left > num)) {
                return true
            }
            // top right corner
            if ((top == null && right == null) && (left > num && bottom > num)) {
                return true
            }
            // left edge
            if ((left == null) && (top > num && bottom > num && right > num)) {
                return true
            }
            // right edge
            if ((right == null) && (top > num && bottom > num && left > num)) {
                return true
            }
            // bottom left corner
            if ((bottom == null && left == null) && (top > num && right > num)) {
                return true
            }
            // bottom edge
            if ((bottom == null) && (top > num && right > num && left > num)) {
                return true
            }
            // bottom right corner
            if ((bottom == null && right == null) && (top > num && left > num)) {
                return true
            }
            // all 4 sides
            if (bottom > num && right > num && top > num && left > num) {
                return true
            }

            return false
        }

        operator fun get(x: Int, y: Int): Int {
            return rows[x][y]
        }
    }

    fun parseIntoGrid(raw: String): Grid {
        val rows = raw.split("\n").map { it.split("").filterNotEmpty().map { s -> s.toInt() } }

        return Grid(rows)
    }
}

operator fun Int?.compareTo(other: Int): Int {
    val nonNull = this ?: -321

    if (nonNull > other) {
        return 1
    }

    return -1
}