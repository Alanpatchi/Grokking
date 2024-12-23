package com.boobalan.leetcode.incomplete

import java.util.Comparator
import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
 */
class `Find K Pairs with Smallest Sums` {

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {

       val priorityQueue = PriorityQueue<List<Int>>(Comparator.comparing { it -> nums1[it[0]] + nums2[it[1]] })
       for (num2 in nums2.indices) {
           priorityQueue.add(listOf(0, num2))
       }

        val returnList= mutableListOf<List<Int>>()
        var enlistedCount = 0
        while (enlistedCount < k) {
            val minPair = priorityQueue.poll()
            returnList.add(listOf(nums1[minPair[0]], nums2[minPair[1]]))
            if (minPair[0] != nums1.lastIndex) {
                priorityQueue.add(listOf(minPair[0] + 1, minPair[1]))
            }
            enlistedCount++

        }
        return returnList
    }
}