package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Unique Paths II Test` {

    @Test
    fun testUniquePathsWithObstacles() {
        Assertions.assertEquals(2, `Unique Paths II`().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,0)
        )))

        Assertions.assertEquals(1, `Unique Paths II`().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,0),
        )))
    }
}