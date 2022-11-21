package com.boobalan.grokking.coding.islands

import java.util.*

fun main(args: Array<String>) {



//    var input = arrayOf(
//        intArrayOf(0, 1, 1, 1, 0),
//        intArrayOf(0, 0, 0, 1, 1),
//        intArrayOf(0, 1, 1, 1, 0),
//        intArrayOf(0, 1, 1, 0, 0),
//        intArrayOf(0, 0, 0, 0, 0)
//    )

    var input = arrayOf(
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1),
        intArrayOf(0, 0, 1, 1, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 1, 0, 0)
    )

    var clone = Array(input.size) {
        i -> input[i].clone()
    }

    DFS.countIslandsDFS(input)

    BFS.countIslandsBFS(clone)
}

class DFS {
    companion object {
        fun countIslandsDFS(input: Array<IntArray>) {
            val rows = input.size
            val cols = input[0].size
            var numberOfIsland = 0


            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    if (input[i][j] == 1) {
                        // found island
                        numberOfIsland++
                        // DFS
                        visitIslandDFS(i, j, input)
                    }
                }
            }

            println(numberOfIsland)
        }

        private fun visitIslandDFS(i: Int, j: Int, input: Array<IntArray>) {  // uses recursion, stack (lifo), dfs
            // valid cell
            if (i < input.size && i > -1 && j < input[0].size && j > -1) {

                // valid land cell
                if (input[i][j] == 1) {
                    // visited
                    input[i][j] = 0

                    // visit nearby cells
                    visitIslandDFS(i, j-1, input)
                    visitIslandDFS(i-1, j, input)
                    visitIslandDFS(i, j+1, input)
                    visitIslandDFS(i+1, j, input)
                }
            }
        }

    }


}

class BFS {

    companion object {
        internal fun countIslandsBFS(input: Array<IntArray>) {
            val rows = input.size
            val cols = input[0].size
            var numberOfIsland = 0


            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    if (input[i][j] == 1) {
                        // found island
                        numberOfIsland++
                        // BFS
                        visitIslandBFS(i, j, input)
                    }
                }
            }

            println(numberOfIsland)
        }


        private fun visitIslandBFS(i: Int, j: Int, input: Array<IntArray>) {  // uses iteration, queue(fifo), bfs

            if (i < input.size && i > -1 && j < input[0].size && j > -1) {

                var queue: Queue<IntArray> = LinkedList()
                queue.add(intArrayOf(i, j));

                while (!queue.isEmpty()) {

                    val elem = queue.remove()
                    val r = elem[0]
                    val c = elem[1]
                    input[r][c] = 0;

                    // enqueue adjacent land cells
                    enqueueLandCell(r, c-1, input, queue)
                    enqueueLandCell(r, c+1, input, queue)
                    enqueueLandCell(r-1, c, input, queue)
                    enqueueLandCell(r+1, c, input, queue)

                }


            }

        }

        private fun enqueueLandCell(r: Int, c: Int, input: Array<IntArray>, queue: Queue<IntArray>) {
            if (r < input.size && r > -1 && c < input[0].size && c > -1) {
                if (input[r][c] == 1) {
                    // enqueue
                    queue.add(intArrayOf(r, c))
                }
            }


        }
    }
}












