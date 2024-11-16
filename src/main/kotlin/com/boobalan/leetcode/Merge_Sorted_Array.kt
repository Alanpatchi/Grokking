package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * Pattern: two pointers
 */
class Merge_Sorted_Array {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        val mergeArray = IntArray(m + n)
        var i = 0

        var p1 = 0
        var p2 = 0
        while (p1 < m && p2 < n) {
            var pick: Int
            val num1 = nums1[p1]
            val num2 = nums2[p2]
            if (num1 < num2) {
                pick = num1
                p1++
            }  else {
                pick = num2
                p2++
            }
            mergeArray[i] = pick
            i++
        }

        if (p1 < m) {
            nums1.copyInto(mergeArray, destinationOffset = i, startIndex = p1, endIndex = m)
        } else {
            nums2.copyInto(mergeArray, destinationOffset = i, startIndex = p2)
        }

        mergeArray.copyInto(nums1)


    }
}

