package com.boobalan.leetcode

import kotlin.math.max

class `Longest Consecutive Sequence` {

    fun longestConsecutive(nums: IntArray): Int {

        val hashSet = hashSetOf<Int>()
        for (num in nums) {
            hashSet.add(num)
        }

        var maxConsecutiveSequenceLength = 0
        for (num: Int in hashSet) {
            if (!hashSet.contains(num - 1)) {
                var sequenceLength = 1
                var nextNum = num + 1
                while (hashSet.contains(nextNum)) {
                    nextNum++
                    sequenceLength++
                }
                maxConsecutiveSequenceLength = max(maxConsecutiveSequenceLength, sequenceLength)
            }
        }
        return maxConsecutiveSequenceLength

    }
}