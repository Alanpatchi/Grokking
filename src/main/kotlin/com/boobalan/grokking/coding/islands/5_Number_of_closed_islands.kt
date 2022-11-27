package com.boobalan.grokking.coding.islands

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0)
    )



    var numberOfClosedIslands = 0

    for (i in matrix.indices) {
        for (j in matrix[0].indices) {

            if (matrix[i][j] == 1) /** land cell **/ {

                if(reconIsland(matrix, i, j)) {
                    numberOfClosedIslands++
                }
            }

        }
    }

    println(numberOfClosedIslands)


}

fun reconIsland(matrix: Array<IntArray>, i: Int, j: Int): Boolean /**returns true in case of closed island**/ {

    val reconQueue: Queue<IntArray> = LinkedList()
    reconQueue.add(intArrayOf(i, j))

    var edgeLandCellFound = false /** true in the case of open island **/

    while (!reconQueue.isEmpty()) {

        val currentCell = reconQueue.remove()
        val r = currentCell[0]
        val c = currentCell[1]

        if (r < 0 || r > matrix.size -1 || c < 0 || c >  matrix[0].size-1) {
            edgeLandCellFound = true
            continue
        }

        if (matrix[r][c] ==1) {
            matrix[r][c] = 0
            reconQueue.add(intArrayOf(r, c-1))
            reconQueue.add(intArrayOf(r, c+1))
            reconQueue.add(intArrayOf(r-1, c))
            reconQueue.add(intArrayOf(r+1, c))

        }
    }

    return !edgeLandCellFound

}
