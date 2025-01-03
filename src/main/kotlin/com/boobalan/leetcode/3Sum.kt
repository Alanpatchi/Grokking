package com.boobalan.leetcode

import java.util.*

class `3Sum` {

    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)


        var firstPosition = 0
        val returnList = mutableListOf<MutableList<Int>>()
        while (firstPosition < nums.size - 2 ) {
            val firstValue = nums[firstPosition]
            twoSum(nums, nums[firstPosition], firstPosition + 1, returnList)
            while (firstPosition < nums.size - 2 && nums[firstPosition] == firstValue) {
                firstPosition++
            }

        }
        return returnList
    }


    fun twoSum(nums: IntArray, firstValue: Int, beginIndex: Int, finalList: MutableList<MutableList<Int>>) {
        val target = -firstValue
        var beginCursor = beginIndex
        var endCursor = nums.lastIndex
        while (beginCursor < endCursor) {
            var matchedBeginValue: Int? = null
            onematchloop@ while (beginCursor < endCursor) {
                val currentPositionSum = nums[beginCursor] + nums[endCursor]
                when {
                    currentPositionSum == target -> {
                        finalList.add(arrayListOf(firstValue, nums[beginCursor], nums[endCursor]))
                        matchedBeginValue = nums[beginCursor]
                        break@onematchloop
                    }

                    currentPositionSum < target -> {
                        beginCursor++
                    }

                    else -> {
                        endCursor--
                    }
                }
            }
            if (matchedBeginValue != null) {
                while (beginCursor < endCursor && matchedBeginValue == nums[beginCursor]) {
                    beginCursor++
                }
            }
        }

    }
}