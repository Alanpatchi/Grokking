package com.boobalan.grokking.coding.islands

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    var input = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    var visited = Array<IntArray>(input.size) { _ -> IntArray(input[0].size) }

    // using bfs
    for (i in input.indices) {
        for (j in input[0].indices) {

            if (input[i][j] == 1 && visited[i][j] == 0) {

                // traverseIsland
                println( traverseIsland(input, i, j, visited) )
            }

        }
    }




}

fun traverseIsland(input: Array<IntArray>, i: Int, j: Int, visited: Array<IntArray>): Int {

    val visitQueue: Queue<IntArray> = LinkedList()
    visitQueue.add(intArrayOf(i, j))

    var perimeter = 0

    while (visitQueue.isNotEmpty()) {

        val head = visitQueue.remove()
        val r = head[0]
        val c = head[1]

        if (r < 0 || r > input.size -1 || c < 0 || c > input[0].size -1) {
            perimeter++
            continue
        }

        if (input[r][c] == 0) {
            perimeter++
        }

        if (input[r][c] == 1 && visited[r][c] == 0) /** not yet visited land**/ {
            visited[r][c] = 1
            visitQueue.addAll(arrayOf(
                intArrayOf(r, c-1),
                intArrayOf(r, c+1),
                intArrayOf(r+1, c),
                intArrayOf(r-1, c),
            ))

        }

    }

    return perimeter

}


