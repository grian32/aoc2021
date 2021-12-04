package util

object Day3 {
    fun mostCommonBitInColumn(row: String): String {
        val oneCount = row.count { it == '1' }
        val zeroCount = row.count { it == '0' }

        return if (oneCount > zeroCount) "1" else "0"
    }

    fun leastCommonBitInColumn(row: String): String {
        val oneCount = row.count { it == '1' }
        val zeroCount = row.count { it == '0' }

        return if (oneCount > zeroCount) "0" else "1"
    }

    fun mostCommonBitInColumnP2(row: String): String {
        val oneCount = row.count { it == '1' }
        val zeroCount = row.count { it == '0' }

        return when {
            oneCount == zeroCount -> "1"
            oneCount > zeroCount -> "1"
            else -> "0"
        }
    }

    fun leastCommonBitInColumnP2(row: String): String {
        val oneCount = row.count { it == '1' }
        val zeroCount = row.count { it == '0' }

        return when {
            oneCount == zeroCount -> "0"
            oneCount > zeroCount -> "0"
            else -> "1"
        }
    }



}