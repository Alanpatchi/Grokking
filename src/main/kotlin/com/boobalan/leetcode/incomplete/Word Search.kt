package com.boobalan.leetcode.incomplete

/**
 * https://leetcode.com/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150
 */
class `Word Search` {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (backtrack(board, i to j, 0, word, HashSet())) {
                    return true
                }
            }
        }
        return false
    }

    private fun backtrack(
        board: Array<CharArray>,
        current: Pair<Int, Int>,
        wordIndex: Int,
        word: String,
        positionsSoFarInThePath: MutableSet<Pair<Int, Int>>
    ): Boolean {

        val (i, j) = current
        if (board[i][j] == word[wordIndex]) {

            if (wordIndex == word.length - 1) {
                // todo return from everything with true
                positionsSoFarInThePath.add(current)
                return true
            } else {
                positionsSoFarInThePath.add(current)

                // for each possible adjacent element that's not in the path

                if (j + 1 in board[0].indices) {
                    // can move right
                    val right = i to j + 1
                    if (!positionsSoFarInThePath.contains(right)) {
                        if (backtrack(board, right, wordIndex + 1, word, positionsSoFarInThePath)) {
                            return true
                        }
                    }
                }

                if (j - 1 in board[0].indices) {
                    // can move left
                    val left = i to j - 1
                    if (!positionsSoFarInThePath.contains(left)) {
                        if (backtrack(board, left, wordIndex + 1, word, positionsSoFarInThePath)) {
                            return true
                        }
                    }
                }

                if (i + 1 in board.indices) {
                    // can move down
                    val down = i + 1 to j
                    if (!positionsSoFarInThePath.contains(down)) {
                        if (backtrack(board, down, wordIndex + 1, word, positionsSoFarInThePath)) {
                            return true
                        }
                    }
                }

                if (i - 1 in board.indices) {
                    // can move up
                    val up = i - 1 to j
                    if (!positionsSoFarInThePath.contains(up)) {
                        if (backtrack(board, up, wordIndex + 1, word, positionsSoFarInThePath)) {
                            return true
                        }
                    }
                }

                positionsSoFarInThePath.remove(current)

                return false


            }

        } else {
            return false
        }
    }
}