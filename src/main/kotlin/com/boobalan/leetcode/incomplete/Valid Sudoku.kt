package com.boobalan.leetcode.incomplete

class `Valid Sudoku` {

    fun isValidSudoku(board: Array<CharArray>): Boolean {

        for (i in 0 until 9) {
            val rowArray = BooleanArray(9)
            val columnArray = BooleanArray(9)
            val boxArray = BooleanArray(9)

            /**
             * mapping i values to r and c values
             *                c-values
             *              0   1   2
             *           0  0...1...2
             *  r-values 1  3...4...5
             *           2  6...7...8
             */
            val r: Int = i / 3
            val c: Int = i % 3

            for (j in 0 until 9) {

                if (board[i][j] != '.') {
                    val digit = board[i][j] - '1'
                    if (rowArray[digit]) {
                        return false
                    } else
                        rowArray[digit] = true
                }

                if (board[j][i] != '.') {
                    val digit = board[j][i] - '1'
                    if (columnArray[digit])
                        return false
                    else
                        columnArray[digit] = true
                }




                /**
                 * mapping j values to gridRow (r-values) and gridColumn(c-values) values
                 *                c-values
                 *              0   1   2
                 *           0  0...1...2
                 *  r-values 1  3...4...5
                 *           2  6...7...8
                 */
                val gridRow: Int = j / 3
                val gridColumn: Int = j % 3

                val row = (r * 3) + gridRow
                val column = (c * 3) + gridColumn

                if (board[row][column] != '.') {
                    val digit = board[row][column] - '1'
                    if (boxArray[digit]) {
                        return false
                    } else
                        boxArray[digit] = true
                }

            }
        }

        return true
    }

}