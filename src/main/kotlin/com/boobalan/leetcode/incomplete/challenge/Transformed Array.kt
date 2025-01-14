package com.boobalan.leetcode.incomplete.challenge

class `Transformed Array` {

    fun constructTransformedArray(nums: IntArray): IntArray {

        val returnArray = IntArray(nums.size)

        for(i in nums.indices) {
            returnArray[i] = nums[(i + nums[i]).mod(nums.size)]
        }

        return returnArray

    }

}