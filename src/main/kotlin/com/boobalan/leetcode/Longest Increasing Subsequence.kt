package com.boobalan.leetcode

import java.util.*

class `Longest Increasing Subsequence` {

    fun lengthOfLIS(nums: IntArray): Int {

        // set of value to length
        val treeSet = TreeSet<Int>()


        for (num in nums) {
            val higher = treeSet.higher(num)
            if (higher == null) {
                treeSet.add(num)
            } else {
                if (!treeSet.contains(num)) {
                    treeSet.remove(higher)
                    treeSet.add(num)
                }

            }
        }

        return treeSet.size


    }
}