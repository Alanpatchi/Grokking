package com.boobalan.grokking.coding.islands

import java.util.LinkedList
import java.util.Queue

fun sizeOfIsland(i: Int, j: Int, input: Array<IntArray>): Int {

    var queue = LinkedList<IntArray>();
    var area = 0
    queue.add(intArrayOf(i, j))

    while (!queue.isEmpty()) {

        val elem = queue.remove()
        val r = elem[0]
        val c = elem[1]
        input[r][c] = 0
        area++

        checkAndAddLandCell(r, c+1, input, queue)
        checkAndAddLandCell(r+1, c, input, queue)
        checkAndAddLandCell(r, c-1, input, queue)
        checkAndAddLandCell(r-1, c, input, queue)
    }

    return area

}

fun checkAndAddLandCell(r: Int, c: Int, input: Array<IntArray>, queue: Queue<IntArray>) {
    if (r < input.size && r > -1 && c < input[0].size && c> -1) {

        if (input[r][c] == 1) {
            queue.add(intArrayOf(r, c))
        }

    }
}

fun main(args: Array<String>) {

    var input = arrayOf(
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1),
        intArrayOf(0, 0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 1, 0, 0)
    )

    var biggestIslandSize = 0
    for (i in input.indices) {
        for (j in input[0].indices) {

            if (input[i][j] == 1) { // island found

                val sizeOfIsland = sizeOfIsland(i, j, input)
                biggestIslandSize = if (biggestIslandSize < sizeOfIsland) sizeOfIsland else biggestIslandSize

            }
        }
    }

    println(biggestIslandSize)



}