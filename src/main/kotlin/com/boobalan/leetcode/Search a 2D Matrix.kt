package com.boobalan.leetcode

class `Search a 2D Matrix` {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val begin = 0
        val m = matrix.size
        val n = matrix[0].size
        val end = (m * n) - 1
        return searchMatrix(matrix, target, begin, end)

    }

    private fun searchMatrix(matrix: Array<IntArray>, target: Int, begin: Int, end: Int): Boolean {

        if (target < getValue(matrix, begin) || target > getValue(matrix, end))
            return false
        else {
            if (begin == end) {
                return target == getValue(matrix, begin)
            }
            val middle = (begin + end) / 2
            val middleValue = getValue(matrix, middle)
            return if (target <= middleValue)
                searchMatrix(matrix, target, begin, middle)
            else
                searchMatrix(matrix, target, middle + 1, end)
        }
    }


    private fun getValue(matrix: Array<IntArray>, position: Int): Int {
        return matrix[position / matrix[0].size][position % matrix[0].size]
    }


}