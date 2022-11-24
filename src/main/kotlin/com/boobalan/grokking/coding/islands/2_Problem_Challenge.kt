package com.boobalan.grokking.coding.islands

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    var input = arrayOf(
        intArrayOf(1, 1, 0, 1),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 0)
    )

    // using bfs

    var distinctTraversal: MutableSet<String> = java.util.HashSet()

    for (i in input.indices) {
        for (j in input[0].indices) {

            if (input[i][j] == 1) {

                traverseIsland(input, i, j, distinctTraversal)

            }

        }
    }

    println(distinctTraversal.size)
}

fun traverseIsland(input: Array<IntArray>, i: Int, j: Int, distinctTraversal: MutableSet<String>){

    val visitQueue: Queue<IntArray> = LinkedList()
    visitQueue.add(intArrayOf(i, j))

    var traversalPath = ""

    while (!visitQueue.isEmpty()) {

        val head = visitQueue.remove()

        // mark cell as visited
        val r = head[0]
        val c = head[1]
        input[r][c] = 0

        // add adjacent land cells
        if (isValidNextLandCell(r, input, c +1)) {
            visitQueue.add(intArrayOf(r, c+1))
            traversalPath += "-r"
        }
        if (isValidNextLandCell(r, input, c -1)) {
            visitQueue.add(intArrayOf(r, c-1))
            traversalPath += "-l"

        }
        if (isValidNextLandCell(r+1, input, c )) {
            visitQueue.add(intArrayOf(r+1, c))
            traversalPath += "+d"

        }
        if (isValidNextLandCell(r-1, input, c)) {
            visitQueue.add(intArrayOf(r-1, c))
            traversalPath += "+u"

        }

    }

   distinctTraversal.add(traversalPath)

}

private fun isValidNextLandCell(
    i: Int,
    input: Array<IntArray>,
    j: Int): Boolean {

    // if valid  cell
    if (i < input.size && i > -1 && j < input[0].size && j > -1) {

        // if land cell
        if (input[i][j] == 1) {
            return true
        }
    }

    return false
}
