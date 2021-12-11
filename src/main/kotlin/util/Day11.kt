package util

object Day11 {
    data class Grid(val rows: MutableList<MutableList<Int>>) {
        operator fun get(x: Int, y: Int): Int {
            if (x < 0 || y < 0 || x >= rows.size || y >= rows[0].size) {
                return 123
            }

            return rows[x][y]
        }

        operator fun set(x: Int, y: Int, value: Int) {
            if (x < 0 || y < 0 || x >= rows.size || y >= rows[0].size) {
                return
            }

            rows[x][y] = value
        }


        fun flash(x: Int, y: Int): Int {
            if (!(x < 0 || y < 0 || x >= rows.size || y >= rows[0].size || this[x, y] <= 9)) {
                var flashes = 0
                this[x, y] = 0

                val locations = listOf(
                    x to y - 1,
                    x to y + 1,
                    x - 1 to y,
                    x + 1 to y,
                    x - 1 to y + 1,
                    x + 1 to y + 1,
                    x - 1 to y - 1,
                    x + 1 to y - 1
                )

                for (i in locations) {
                    val x = i.first
                    val y = i.second
                    if (this[x, y] >= 9)  flashes += flash(x, y);
                }

                return flashes
            }

            return 1
        }
    }

    fun parseIntoGrid(raw: String): Grid {
        val rows = raw.split("\n").map { it.split("").filterNotEmpty().map { s -> s.toInt() } }

        return Grid(rows.map { it.toMutableList() }.toMutableList())
    }
}