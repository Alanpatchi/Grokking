package com.boobalan.leetcode

import java.util.LinkedList
import kotlin.math.min

class `Snakes and Ladders` {

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val queue = LinkedList<Int>()
        val n = board.size
        val nSquared = n * n
        val markedArray = IntArray(nSquared)
        queue.offer(0)
        markedArray[0] = 1
        while (queue.isNotEmpty()) {
            val currentPosition = queue.poll()
            val currentStepCount = markedArray[currentPosition]
            if (currentPosition == nSquared - 1)
                return currentStepCount - 1
            for (i in currentPosition + 1..min(nSquared - 1, currentPosition + 6)) {

                when (val boardValue = board[getRowPosition(i, n)][getColPosition(i, n)]) {
                    -1 -> {
                        if (markedArray[i] == 0) {
                            queue.offer(i)
                            markedArray[i] = currentStepCount + 1
                        }

                    }

                    else -> {
                        if (markedArray[boardValue - 1] == 0) {
                            queue.offer(boardValue - 1)
                            markedArray[boardValue - 1] = currentStepCount + 1
                        }
                    }
                }
            }
        }
        return -1

    }

    private fun getRowPosition(position: Int, n: Int): Int {
        return (n - 1) - ((position) / n)
    }

    private fun getColPosition(position: Int, n: Int): Int {
        val mod2n = (position).mod(2 * n)
        return if (mod2n < n) {
            mod2n
        } else {
            (n - 1) - ((position).mod(n))
        }
    }

}