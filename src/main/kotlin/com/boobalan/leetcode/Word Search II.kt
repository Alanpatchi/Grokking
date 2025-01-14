package com.boobalan.leetcode

class `Word Search II` {

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val returnList = mutableListOf<String>();
        wordLoop@for(word in words) {
            for (i in board.indices) {
                for (j in board[0].indices) {
                    val foundWord = search(board, i to j, word, 0, HashSet())
                    if (foundWord) {
                        returnList.add(word)
                        continue@wordLoop
                    }
                }
            }
        }
        return returnList

    }

    fun search(board: Array<CharArray>, boardPosition: Pair<Int, Int>, word: String, wordPosition: Int, visitedBoard: MutableSet<Pair<Int, Int>>): Boolean {

        if (visitedBoard.contains(boardPosition)) {
            return false
        }
        if (boardPosition.first !in board.indices || boardPosition.second !in board[0].indices) {
            return false
        }

        val (row, col) = boardPosition
        var isFound = false
        if (board[row][col] == word[wordPosition]) {
            visitedBoard.add(boardPosition)
            if (wordPosition == word.lastIndex) {
                isFound = true
            } else {

                // search for the next word to the right

                if (search(board, row to col + 1, word, wordPosition + 1, visitedBoard) ||
                    search(board, row to col - 1, word, wordPosition + 1, visitedBoard) ||
                    search(board, row + 1 to col, word, wordPosition + 1, visitedBoard) ||
                    search(board, row - 1 to col, word, wordPosition + 1, visitedBoard)) {
                    isFound = true
                }

            }
            visitedBoard.remove(boardPosition)
        }
        return isFound
    }
}