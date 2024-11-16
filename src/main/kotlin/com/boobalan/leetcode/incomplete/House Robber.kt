package com.boobalan.leetcode.incomplete

import kotlin.math.max

class `House Robber` {

    fun rob(nums: IntArray): Int {
//        val dp = nums
        // dp[i] = max(nums[i] + dp[i-2], dp[i-1])

        val dp = nums
        if(nums.size ==1)
            return nums[0]

        dp[1] = max(dp[0], nums[1])

        for(i in 2 until nums.size) {
            dp[i] = max(nums[i] + dp[i -2], dp[i-1])
        }
        return dp.last()
    }
}