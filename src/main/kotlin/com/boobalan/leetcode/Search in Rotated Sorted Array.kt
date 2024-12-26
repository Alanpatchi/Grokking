package com.boobalan.leetcode

import java.util.*
import java.util.Collections.binarySearch

class `Search in Rotated Sorted Array` {

    fun search(nums: IntArray, target: Int): Int {

        if (nums.size == 1) {
            return if (nums.first() == target)
                0
            else
                -1
        } else {
            val k = getKIndexOfRotation(nums)
            val list = nums.asList()

            if (k != -1) {

                if (target >= nums[0]) {
                    val binarySearch = binarySearch(list.subList(0, k + 1), target)
                    return if(binarySearch >= 0) {
                        binarySearch
                    } else {
                        -1
                    }
                } else {
                    val binarySearch = binarySearch(list.subList(k + 1, list.size), target)
                    return if (binarySearch >= 0) {
                        binarySearch + k + 1
                    } else {
                        -1
                    }
                }
            } else {
                val binarySearch = binarySearch(list, target)
                return if (binarySearch >= 0) {
                    binarySearch
                } else {
                    -1
                }
            }



        }

    }

    fun getKIndexOfRotation(nums: IntArray): Int {
        var firstIndex = 0
        var lastIndex = nums.lastIndex
        var isIntervalWithK = nums[firstIndex] > nums[lastIndex]
        while (isIntervalWithK) {
            val midPoint = (firstIndex + lastIndex) / 2
            if (nums[midPoint] > nums[midPoint+1]) {
                return midPoint
            } else {
               if (nums[firstIndex] > nums[midPoint]) {
                   lastIndex = midPoint - 1
               } else {
                   firstIndex = midPoint + 1
               }
            }
            isIntervalWithK = isIntervalWithK(nums, firstIndex, lastIndex)

        }
        return -1
    }


    fun isIntervalWithK(nums: IntArray, begin: Int, end: Int): Boolean {
        if (nums[begin] > nums[end]) {
            return true
        } else {
            if (end != nums.lastIndex) {
                return nums[end] > nums[end + 1]
            } else {
                return false
            }
        }
    }
}