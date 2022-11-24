package com.boobalan.grokking.coding.islands

import java.util.LinkedList
import java.util.Queue

class FloodFill {
    companion object {
        fun floodFill(matrix: Array<IntArray>, x: Int, y: Int, color: Int) {

            val queue: Queue<IntArray> = LinkedList()

            val origValue = matrix[x][y]
            queue.add(intArrayOf(x, y))

            while (!queue.isEmpty()) {

                val head = queue.remove();
                val i = head[0]
                val j = head[1]
                // if valid cell
                if (i < matrix.size && i > -1 && j < matrix[0].size && j > -1) {

                    // if cell as same value as origValue
                    if (matrix[i][j] == origValue) {

                        matrix[i][j] = color

                        queue.add(intArrayOf( i, j-1 ))
                        queue.add(intArrayOf( i-1, j ))
                        queue.add(intArrayOf( i+1, j ))
                        queue.add(intArrayOf( i, j+1 ))


                    }

                }
            }

           matrix.forEach { ints: IntArray -> println( ints.contentToString() ) }
        }
    }
}

fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    FloodFill.floodFill(
        matrix, 1, 3, 2
    )


}