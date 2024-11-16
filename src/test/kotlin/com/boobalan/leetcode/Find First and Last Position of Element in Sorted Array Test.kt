package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Find First and Last Position of Element in Sorted Array Test` {


    @Test
    fun testSearchRange() {

        Assertions.assertArrayEquals(
            `Find First and Last Position of Element in Sorted Array`().searchRange(intArrayOf(5,7,7,8,8,10), 8),
            intArrayOf(3, 4)
        )

        Assertions.assertArrayEquals(
            `Find First and Last Position of Element in Sorted Array`().searchRange(intArrayOf(1, 1, 2), 1),
            intArrayOf(0, 1)
        )
    }
}