package com.boobalan.leetcode

/**
 * Constraints:
 *
 * https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 */
class `Contains Duplicate II` {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {

        val map = hashSetOf<Int>()

        val initialWindowSize = minOf(k + 1, nums.size)
        for (i in 0 until initialWindowSize) {
            if (!map.contains(nums[i])) {
                map.add(nums[i])
            } else {
                return true
            }
        }

        for (i in initialWindowSize until nums.size) {

            map.remove(nums[i - k - 1])
            if (!map.contains(nums[i])) {
                map.add(nums[i])
            } else {
                return true
            }
        }

        return false

    }
}