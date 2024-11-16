package com.boobalan.leetcode

import java.util.LinkedList

/**
 *
 * logic development finished at 12 mins 28 secs;
 * solution finished at 55 mins 4 secs
 * https://leetcode.com/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Pattern: BackTracking
 */
class Combination_Sum {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val finalList = mutableListOf<List<Int>>()
        backTrackingSolution(LinkedList(), 0, 0, finalList, target, candidates)
        return finalList;

    }

    private fun backTrackingSolution (trackingList: MutableList<Int>, position: Int, trackingListSum: Int, finalList: MutableList<List<Int>>, target: Int, candidates: IntArray) {

        when {
            trackingListSum == target -> {
                finalList.add(trackingList.toMutableList())
                return
            }
            trackingListSum > target -> {
                return
            }
            trackingListSum < target -> {
                for (i in position until candidates.size) {
                    trackingList.add(candidates[i])
                    val newTrackingListSum = trackingListSum + candidates[i]
                    backTrackingSolution(trackingList, i, newTrackingListSum, finalList, target, candidates)
                    trackingList.removeLast()
                }
            }
        }

    }
}

fun main(args: Array<String>) {
    val combinationSumList = Combination_Sum().combinationSum(intArrayOf(2, 3, 6, 7), 7)
    combinationSumList.forEach { println(it.toIntArray().contentToString()) }
}