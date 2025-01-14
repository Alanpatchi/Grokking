package com.boobalan.leetcode

class `Set Matrix Zeroes` {

    fun setZeroes(matrix: Array<IntArray>): Unit {


        var shouldFirstRowBeZero = false
        var shouldFirstColumnBeZero = false
        if (matrix[0][0] == 0) {
            shouldFirstColumnBeZero = true
            shouldFirstRowBeZero = true
        }

        if (!shouldFirstColumnBeZero) {
            for (row in 1.. matrix.lastIndex) {
                if (matrix[row][0] == 0) {
                    shouldFirstColumnBeZero = true
                    break
                }
            }
        }

        if (!shouldFirstRowBeZero) {    
            for (col in 1.. matrix[0].lastIndex) {
                if (matrix[0][col] == 0) {
                    shouldFirstRowBeZero = true
                    break
                }
            }
        }

        //set the ref values
        for (row in 1 .. matrix.lastIndex) {
            for (col in 1.. matrix[0].lastIndex) {
                if (matrix[row][col] == 0) {
                    setRefColumnsRowValueToZero(matrix, row)
                    setRefRowsColumnValueToZero(matrix, col)
                }
            }
        }



        for (row in 1 .. matrix.lastIndex) {
            for (col in 1.. matrix[0].lastIndex) {
                if (isRefColumnsRowValueZero(matrix, row) || isRefRowsColumnValueZero(matrix, col)) {
                    matrix[row][col] = 0
                }
            }
        }


        if (shouldFirstRowBeZero) {
            for (col in 0..matrix[0].lastIndex) {
                matrix[0][col] = 0
            }
        }

        if (shouldFirstColumnBeZero) {
            for (row in 0..matrix.lastIndex) {
                matrix[row][0] = 0
            }
        }


    }

    private fun setRefColumnsRowValueToZero(matrix: Array<IntArray>, row: Int) {
        matrix[row][0] = 0
    }

    private fun isRefColumnsRowValueZero(matrix: Array<IntArray>, row: Int): Boolean {
        return matrix[row][0] == 0
    }

    private fun setRefRowsColumnValueToZero(matrix: Array<IntArray>, col: Int) {
        matrix[0][col] = 0
    }

    private fun isRefRowsColumnValueZero(matrix: Array<IntArray>, col: Int): Boolean {
        return matrix[0][col] == 0
    }

}