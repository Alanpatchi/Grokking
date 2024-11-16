package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
class Remove_Duplicates {

    /**
     * nums - sorted array
     */
    fun removeDuplicates(nums: IntArray): Int {

        var from = 0
        var to = 0
        while(to < nums.size && from < nums.size) {
            nums[to] = nums[from]
            to++
            var k = 1
            try {
                while (nums[from + k] == nums[from]) {
                    k++
                }
            } catch (e: Exception) {
                break
            }
            from += k

        }
        return to // returned to-1 instead of to

    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(1, 1, 2)
    println(Remove_Duplicates().removeDuplicates(input))
    println(input.contentToString())
}