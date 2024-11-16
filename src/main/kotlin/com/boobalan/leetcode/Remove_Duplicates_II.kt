package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
class Remove_Duplicates_II {

    fun removeDuplicates(nums: IntArray): Int {
        var from = 0
        var to = 0
        while (from < nums.size) {
            nums[to] = nums[from]
            to++
            var repeatEntryFlag = false
            var k = 1
            try {
                while (nums[from + k] == nums[from]) {
                    repeatEntryFlag = true
                    k++
                }
            } catch (_: Exception) {
                if (repeatEntryFlag) {
                    from = from + k - 1
                    continue
                } else {
                    break
                }
            }
            from = if (repeatEntryFlag) {
                from + k - 1
            } else {
                from + k
            }

        }
        return to
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    println( Remove_Duplicates_II().removeDuplicates(input))
    println( input.contentToString() )

}