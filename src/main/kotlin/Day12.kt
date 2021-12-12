import java.io.File

class Day12 {
    private val cave = File("src/main/resources/day12.txt").readText().parseCave()

    fun part1(): Int {
        cave.allPathsP1("start", "end", mutableSetOf())

        return cave.pathCountP1
    }

    fun part2(): Int {
        cave.allPathsP2("start", "end", mutableSetOf(), false)

        return cave.pathCountP2
    }

    private fun String.parseCave(): Graph {
        val rows = split("\n")
        val graph = Graph()
        for (i in rows) {
            val splitVal = i.split("-")

            graph.addNodeWithNeighbour(splitVal[0], splitVal[1])
        }

        return graph
    }

    private class Graph {
        // map of node to its neighbours
        val nodes: MutableMap<String, MutableSet<String>> = mutableMapOf()
        var pathCountP1 = 0
        var pathCountP2 = 0

        fun addNodeWithNeighbour(node: String, name: String) {
            if (!nodes.containsKey(node)) {
                nodes[node] = mutableSetOf()
            }

            if (!nodes.containsKey(name)) {
                nodes[name] = mutableSetOf()
            }

            if (name != "start") nodes[node]?.add(name)
            if (node != "start") nodes[name]?.add(node)
        }


        fun allPathsP1(current: String, end: String, visited: MutableSet<String>) {
            val neighbours = nodes[current]!!

            if (current == end) {
                pathCountP1++
                return
            }

            for (i in neighbours) {
                if (i !in visited) {
                    if (current.lowercase() == current) {
                        visited.add(current)
                    }
                    allPathsP1(i, end, visited.toMutableSet())
                }
            }
        }

        fun allPathsP2(current: String, end: String, visited: MutableSet<String>, secondCaveFound: Boolean) {
            if (current == end) {
                pathCountP2++
                return
            }

            val neighbours = nodes[current]!!

            if (current.lowercase() == current) {
                visited.add(current)
            }

            for (i in neighbours) {
                if (i !in visited) {
                    allPathsP2(i, end, visited.toMutableSet(), secondCaveFound)
                } else if (!secondCaveFound) {
                    allPathsP2(i, end, visited.toMutableSet(), true)
                }
            }
        }
    }
}

fun main() {
    val day12 = Day12()

    println("PART 1\n---")
    println(day12.part1())
    println("PART 2\n---")
    println(day12.part2())
}