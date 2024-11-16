package com.boobalan.grokking.leetcode


fun twoSum(nums: IntArray, target: Int): IntArray {

    // sort
    val wrappers = Array(nums.size) {i -> intArrayOf(nums[i], i) }
    wrappers.sortBy { it[0] }

    // 2 pointer
    var pt1 = 0
    var pt2 = wrappers.size -1

    loop@ while (pt1 <= pt2) {
        val sum = wrappers[pt1][0] + wrappers[pt2][0]
        when {
            sum < target -> pt1++
            sum > target -> pt2--
            else -> break@loop
        }
    }

    return intArrayOf(wrappers[pt1][1], wrappers[pt2][1])




}

fun main(args: Array<String>) {

    var result = twoSum(intArrayOf(3, 3), 6)
    println(result.contentToString())

}