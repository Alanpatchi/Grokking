package com.boobalan.leetcode

/**
 *
 * https://leetcode.com/problems/single-number-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * Constraints:
 *   1 <= nums.length <= 3 * 104
 *   -231 <= nums[i] <= 231 - 1
 *   Each element in nums appears exactly three times except for one element which appears once.
 *
 */
class `Single Number II` {

    fun singleNumber(nums: IntArray): Int {

        val digitSumArray = IntArray(32)
        for (num in nums) {

            for (i in digitSumArray.indices) {
                digitSumArray[i] += (num ushr i) and 1
            }
        }

        var result = 0
        for (i in digitSumArray.indices) {
            val ithBit = (digitSumArray[i] % 3)
            result = result or (ithBit shl i)
        }

        return result

    }

}