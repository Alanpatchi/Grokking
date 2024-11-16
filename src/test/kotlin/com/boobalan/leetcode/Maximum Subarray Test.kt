package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Maximum Subarray Test` {

    @Test
    fun testMaxSubArray() {
        Assertions.assertEquals(6, `Maximum Subarray`().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
        Assertions.assertEquals(1, `Maximum Subarray`().maxSubArray(intArrayOf(1)))
        Assertions.assertEquals(23, `Maximum Subarray`().maxSubArray(intArrayOf(5,4,-1,7,8)))
        Assertions.assertEquals(-1, `Maximum Subarray`().maxSubArray(intArrayOf(-1)))

    }
}