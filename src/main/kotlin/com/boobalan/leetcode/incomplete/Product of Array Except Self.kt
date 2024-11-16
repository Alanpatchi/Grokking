package com.boobalan.leetcode.incomplete

class `Product of Array Except Self` {

    fun productExceptSelf(nums: IntArray): IntArray {
        val returnArray = IntArray(nums.size)
        returnArray[0] = 1
        for(i in 1 until nums.size) {
            returnArray[i] = returnArray[i-1] * nums[i-1]
        }
        var sumToMultiply = nums.last()
        for (i in nums.size -2 downTo    0) {
            returnArray[i] *= sumToMultiply
            sumToMultiply *= nums[i]
        }
        return returnArray
    }

}