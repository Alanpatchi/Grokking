package com.boobalan.grokking.leetcode

import java.util.LinkedList

private class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val l1: Int = nums1.size
        val l2 = nums2.size

        val necessaryPos = LinkedList<Int>()
        val maxElemPosNeeded: Int = when((l1 + l2) % 2)  {
            0 -> {
                val leftPos = ((l1 + l2)/2) -1
                necessaryPos.add(leftPos)
                necessaryPos.add(leftPos + 1)
                leftPos + 1
            }
            else -> {
                val onlyElementNeeded = (l1 + l2 - 1) / 2
                necessaryPos.add(onlyElementNeeded)
                onlyElementNeeded
            }
        }
        val N = necessaryPos.size
        var currentPos = 0
        var i1 = 0
        var i2 = 0
        var positionExpected = necessaryPos.remove()
        var sum = 0
        while (currentPos <= maxElemPosNeeded) {

            val nums1Elem = if (i1 < nums1.size) {
                nums1[i1]
            } else {
                Int.MAX_VALUE
            }
            val nums2Elem =  if (i2 < nums2.size) {
                nums2[i2]
            } else {
                Int.MAX_VALUE
            }
            if (nums1Elem <= nums2Elem) {

                if (currentPos == positionExpected) {
                    sum += nums1Elem
                    positionExpected = if (necessaryPos.isNotEmpty()) {
                        necessaryPos.remove()
                    } else {
                        null
                    }
                }
                i1++
                currentPos++

            } else {

                if (currentPos == positionExpected) {
                    sum += nums2Elem
                    positionExpected = if (necessaryPos.isNotEmpty()) {
                        necessaryPos.remove()
                    } else {
                        null
                    }
                }
                i2++
                currentPos++
            }

        }

        return sum.toDouble().div(N)


    }
}

fun main(args: Array<String>) {
    println(Solution().findMedianSortedArrays(intArrayOf(), intArrayOf(3, 4)))
}