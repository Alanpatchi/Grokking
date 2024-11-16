package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Minimum Number of Arrows to Burst Balloons Test` {

    @Test
    fun testFindMinArrowShots() {
        val points = arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12))

        Assertions.assertEquals(2, `Minimum Number of Arrows to Burst Balloons`().findMinArrowShots(points))
    }
}