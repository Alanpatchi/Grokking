package com.boobalan.leetcode

class `Majority_Element(Custom_algo)` {

    /**
     * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
     * Solution: Boyer-Moore Majority Voting Algorithm
     */
    fun majorityElement(nums: IntArray): Int {

        var candidate: Int = 0 // random candidate
        var count = 0

        for (i in nums.iterator()) {
            if (count == 0) {
                candidate = i
            }
            if (candidate == i) {
                count++
            } else {
                count--
            }
        }

        return candidate
    }

}