package com.boobalan.leetcode

import java.util.*

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
class `Find First and Last Position of Element in Sorted Array` {

    fun searchRange(nums: IntArray, target: Int): IntArray {

        val index = Arrays.binarySearch(nums, target)
        return if (index > -1) {
            // target found
            var lowerEnd = index
            while (lowerEnd-1 > -1 && nums[lowerEnd-1] == target) {
                lowerEnd--
            }

            var upperEnd = index
            while (upperEnd+1 < nums.size && nums[upperEnd +1] == target) {
                upperEnd++
            }
            intArrayOf(lowerEnd, upperEnd)
        } else {
            intArrayOf(-1, -1)
        }

    }
}