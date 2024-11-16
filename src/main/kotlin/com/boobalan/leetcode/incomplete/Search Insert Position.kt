package com.boobalan.leetcode.incomplete

import kotlin.math.max
import kotlin.math.min

class `Search Insert Position` {

    fun searchInsert(nums: IntArray, target: Int): Int {
        return searchInsert(nums, target, 0, nums.size -1)
    }

    fun searchInsert(nums: IntArray, target: Int, begin: Int, end: Int): Int {

        val middleIndex = (begin + end) / 2
        if (nums[middleIndex] == target) {
            return middleIndex
        } else {
            if (begin == end) {
                if (nums[begin] < target) {
                    return begin + 1
                } else
                    return begin
            } else {
                if (nums[middleIndex] < target) {
                    return searchInsert(nums, target, min(middleIndex + 1, end), end)
                } else {
                    return searchInsert(nums, target, begin, max(middleIndex -1, begin))
                }
            }
        }
    }
}