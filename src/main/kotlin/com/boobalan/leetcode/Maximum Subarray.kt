package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-interview-150
 * Pattern: sliding window (windows are adjusted using Kadane's algorithm)
 * TODO Another Pattern: Divide and conquer
 */
class `Maximum Subarray` {

    fun maxSubArray(nums: IntArray): Int {

//        var windowBegin = 0
//        var windowEnd = 0
        var windowSum = nums[0]
        var currentMaxWindowSum = nums[0]

        for (i in 1 until nums.size) {
            val tempWindowSum = windowSum + nums[i]
            windowSum = if (tempWindowSum > nums[i]) {
        //                windowEnd = i
                tempWindowSum
            } else {
        //                windowBegin = i
        //                windowEnd = i
                nums[i]
            }
            if (windowSum > currentMaxWindowSum) {
                currentMaxWindowSum = windowSum
            }
        }

        return currentMaxWindowSum
    }

}