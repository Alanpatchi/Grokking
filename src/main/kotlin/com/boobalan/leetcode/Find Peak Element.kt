package com.boobalan.leetcode

class `Find Peak Element` {

    fun findPeakElement(nums: IntArray): Int {
        return if (nums.size == 1) {
            0
        } else {
            if (nums[0] > nums[1]) {
                0
            } else {
                if (nums.last() > nums[nums.size - 2])
                    nums.size - 1
                else {
                    findPeakElement(nums, 0, nums.size-1)
                }
            }
        }

    }

    private fun findPeakElement(nums: IntArray, from: Int, to: Int): Int {

        val middleIndex = (from + to) / 2
        val middleElement = nums[middleIndex]
        val prevElement = nums[middleIndex - 1]
        val nextElement = nums[middleIndex + 1]
        return when  {
            middleElement > prevElement && middleElement > nextElement -> return middleIndex
            middleElement > prevElement && middleElement < nextElement -> findPeakElement(nums, middleIndex, to)
            else -> findPeakElement(nums, from, middleIndex)
        }


    }



}