package com.boobalan.leetcode.incomplete.challenge

import kotlin.math.max
import kotlin.math.min

class `Maximum Subarray Sum With Length Divisible by K` {

    fun maxSubarraySum(nums: IntArray, k: Int): Long {

        val dp = LongArray(nums.size)
        var sum: Long = 0
        for (i in 0 until min(k, nums.size)) {
            sum += nums[i]
            dp[i] = sum
        }
        var maxSubarraySum: Long = dp[min(k, nums.size) -1]



        var windowSum = sum
        for (i in k until nums.size) {
            windowSum = windowSum + nums[i] - nums[i - k]

            if (i -k < k-1) {
                dp[i] = windowSum
            } else {
                if (dp[i - k] <= 0) {
                    dp[i] = windowSum
                } else {
                    dp[i] = windowSum + dp[i - k]
                }
            }
            maxSubarraySum = max(maxSubarraySum, dp[i])
        }
        return maxSubarraySum

    }
}