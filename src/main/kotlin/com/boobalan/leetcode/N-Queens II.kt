package com.boobalan.leetcode

import kotlin.math.abs

class `N-Queens II` {

    fun totalNQueens(n: Int): Int {

        // completedBoardCount = 0
        // placedQueens list init as empty
        // for each row i in 1 to n

        // previously tried j (j could be in 1 to n) (init to 0)
        // try if (i, (next j)) is under attack from any of the queens in the placedQueens list  ; -> here (next j) could be from [j + 1, n)
        // pick next j, place the (i, j) element in the placedQueens and
                // pass the placedQueens list, i+1 (row to try placing next queen); (if the board is complete (the board is complete is j == n and placement of attempted queen is successful, add one to completedBoard count)

        // return completedBoardCount


        val completedBoardCount = intArrayOf(0)
        val placedQueens = mutableListOf<IntArray>()

        tryPlacingNewQueenAtIthRow(placedQueens, 1, n, completedBoardCount)

        return completedBoardCount[0]

    }

    private fun tryPlacingNewQueenAtIthRow(placedQueens: MutableList<IntArray>, i: Int, n: Int, completedBoardCount: IntArray){

        for (j in 1..n) {
            var positionUnderAttack = false
            for (queenPos in placedQueens) {
                if (checkIfIJIsUnderAttack(i, j, queenPosI = queenPos[0], queenPosJ = queenPos[1])) {
                    positionUnderAttack = true
                    break
                }
            }
            if (!positionUnderAttack) {
                placedQueens.add(intArrayOf(i, j))
                if (placedQueens.size == n) {
                    completedBoardCount[0] = completedBoardCount[0] + 1
                } else {
                    tryPlacingNewQueenAtIthRow(placedQueens, i + 1, n, completedBoardCount)
                }
                placedQueens.removeLast()
            }

        }

    }

    private fun checkIfIJIsUnderAttack(i: Int, j: Int, queenPosI: Int, queenPosJ: Int): Boolean {

        if (i == queenPosI)
            return true
        if (j == queenPosJ)
            return true
        if (abs(i - queenPosI) == abs(j - queenPosJ))
            return true

        return false
    }
}