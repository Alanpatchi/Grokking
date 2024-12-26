package com.boobalan.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * todo can be optimized
 */
class `Jump Game II` {

    fun jump(nums: IntArray): Int {

        val minRequiredJumps = IntArray(nums.size) {nums.size + 1}
        minRequiredJumps[0] = 0

        for (i in nums.indices) {
            val minJumpToCurrentPosition = minRequiredJumps[i]
            var maxJump = nums[i]
            maxJump = min(maxJump, nums.lastIndex - i)
            for (jump in 1 .. maxJump) {
                minRequiredJumps[i + jump] = min(minRequiredJumps[i + jump], minJumpToCurrentPosition + 1)
            }
        }

        return minRequiredJumps.last()

    }
}