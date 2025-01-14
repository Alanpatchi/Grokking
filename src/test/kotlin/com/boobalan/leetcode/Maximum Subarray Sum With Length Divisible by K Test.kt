package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.challenge.`Maximum Subarray Sum With Length Divisible by K`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Maximum Subarray Sum With Length Divisible by K Test` {

    @Test
    fun maxSubarraySumTest() {
        val maxSubarraySum = `Maximum Subarray Sum With Length Divisible by K`().maxSubarraySum(intArrayOf(1, 2), 1)
        assertEquals(3, maxSubarraySum)

    }

    @Test
    fun maxSubarraySumTest2() {
        val maxSubarraySum = `Maximum Subarray Sum With Length Divisible by K`().maxSubarraySum(intArrayOf(-1,-2,-3,-4,-5), 4)
        assertEquals(-10, maxSubarraySum)

    }

    @Test
    fun maxSubarraySumTest3() {
        val maxSubarraySum = `Maximum Subarray Sum With Length Divisible by K`().maxSubarraySum(intArrayOf(-5,1,2,-3,4), 2)
        assertEquals(4, maxSubarraySum)

    }
}