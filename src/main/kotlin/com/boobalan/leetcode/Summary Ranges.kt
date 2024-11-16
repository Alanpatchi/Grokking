package com.boobalan.leetcode

class `Summary Ranges` {

    fun summaryRanges(nums: IntArray): List<String> {
        val ranges = mutableListOf<String>()
        var endIndexOfRange = -1
        var beginIndexOfRange = 0
        while (endIndexOfRange != nums.size -1) {
            endIndexOfRange = findContinuousRange(beginIndexOfRange, nums)
            if (beginIndexOfRange == endIndexOfRange) {
                ranges.add("${nums[beginIndexOfRange]}")
            } else {
                ranges.add("${nums[beginIndexOfRange]}->${nums[endIndexOfRange]}")
            }
            beginIndexOfRange = endIndexOfRange+1
        }
        return ranges
    }

    // return endIndex (inclusive) where [startIndex, endIndex] makes continuous range
    fun findContinuousRange(startIndex: Int, nums: IntArray): Int {

        var index = startIndex
        while (index+1 < nums.size && nums[index+1] == nums[index] + 1) {
            index++
        }
        return index
    }
}