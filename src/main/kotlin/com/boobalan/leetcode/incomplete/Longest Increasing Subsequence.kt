package com.boobalan.leetcode.incomplete

import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {

    println( `Longest Increasing Subsequence`().lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}

class `Longest Increasing Subsequence` {

    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1)
        dp[0] = 0
        dp[1] = 1
        val indexArrayOfIncreasingValues = ArrayList<Pair<Int, Int>>()
        indexArrayOfIncreasingValues.add(nums[0] to 0)
        val prevValueSearchComparator = Comparator.comparingInt<Pair<Int, Int>>{ it.first }.thenByDescending { it.second }
        val insertComparator= Comparator.comparing(Pair<Int, Int>::first).thenComparing(Pair<Int, Int>::second)

        for (i in 1 until nums.size) {
            val currentPair = nums[i] to i
            val subList = indexArrayOfIncreasingValues.subList(0, i - 1)
            val previousValueSearch = Collections.binarySearch(subList, currentPair, prevValueSearchComparator)
            val currentValueInsertSearch = Collections.binarySearch(subList, currentPair, insertComparator)
            if (previousValueSearch >= 0) {
                throw IllegalStateException("search index cannot be +ve")
            }
            val previousValueIndex =  -1  -previousValueSearch
            if (previousValueIndex ==0 ) {
                dp[i + 1] = 1
            } else {
                val prevValue = subList[previousValueIndex -1]
                dp[i + 1] = dp[prevValue.second] + 1
            }
            val insertIndex =  -1-currentValueInsertSearch
           indexArrayOfIncreasingValues.add(insertIndex, currentPair)

        }
        return dp[nums.size]
    }


}