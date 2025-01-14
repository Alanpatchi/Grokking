package com.boobalan.leetcode.incomplete

import kotlin.math.min

class `Minimum Size Subarray Sum` {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var returnLen = 0
        // initialization
        var windowSum = 0
        var i = 0
        while (windowSum < target) {
            if (i == nums.size) {
                return 0
            }
            windowSum+= nums[i]
            i++
        }
        var windowBegin = 0
        var windowEnd = i-1
        while (windowSum - nums[windowBegin] >= target) {
            windowSum -= nums[windowBegin]
            windowBegin++
        }
        returnLen = windowEnd - windowBegin + 1

        windowEnd = i
        while (windowEnd != nums.size) {
            windowSum +=nums[windowEnd]
            while (windowSum - nums[windowBegin] >= target) {
                windowSum -= nums[windowBegin]
                windowBegin++
            }
            returnLen = min(returnLen, windowEnd - windowBegin + 1)
            windowEnd++
        }
        return returnLen
    }
}