package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 *
 * Pattern: dynamic programming using memoization
 *
 *
 * logic by 7mins 22 sec
 * finished by 27 mins 14 sec
 */
class Jump_Game {

    fun canJump(nums: IntArray): Boolean {

        // init
        val reachable: Array<Boolean?> = arrayOfNulls(nums.size)
        reachable[0] = true
        return isPositionReachable(nums.size -1, nums, reachable)
    }

    private fun isPositionReachable(position: Int, nums: IntArray, reachable: Array<Boolean?>): Boolean {

        if (reachable[position] != null) {
            return reachable[position]!!
        } else {

            var reachStatus = false
            loop@ for (i in position-1 downTo 0) {

                if (position - i <= nums[i]) {
                    reachStatus = isPositionReachable(i, nums, reachable)
                    if (reachStatus) {
                        break@loop
                    }
                }


            }
            reachable[position] = reachStatus
            return reachStatus

        }
    }
}

fun main(args: Array<String>) {

        val nums = intArrayOf(2,3,1,1,4)
        println(Jump_Game().canJump(nums))

}