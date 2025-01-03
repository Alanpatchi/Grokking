package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Search a 2D Matrix Test` {

    @Test
    fun searchMatrix() {
        val searchMatrix = `Search a 2D Matrix`().searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ),
            3

        )
        assertTrue(searchMatrix)
    }
}