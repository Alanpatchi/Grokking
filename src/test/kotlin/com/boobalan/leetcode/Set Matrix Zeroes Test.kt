package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class `Set Matrix Zeroes Test` {

    @Test
    fun setZeroes() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5),
        )
        `Set Matrix Zeroes`().setZeroes(
            matrix = matrix
        )

        assertArrayEquals(
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 4, 5, 0),
                intArrayOf(0, 3, 1, 0),
            ),
            matrix,
            )
    }
}