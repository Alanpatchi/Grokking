package com.boobalan.leetcode

fun main(args: Array<String>) {
//    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
//    println( Remove_Element().removeElement(nums, 2) )
//    val nums = intArrayOf(0, 4, 4, 0, 4, 4, 4, 0, 2)
//    println( Remove_Element().removeElement(nums, 4) )
    val nums = intArrayOf( 2)
    println( Remove_Element().removeElement(nums, 3) )
    println( nums.contentToString() )
}

/**
 * https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 */
class Remove_Element {

    fun removeElement(nums: IntArray, `val`: Int): Int {

        var to = nums.size-1;
        var from = 0
        while (from <= to) {

            while (from <= to && nums[from] != `val`) {
                from++
            }

            while (from <= to && nums[to] == `val`) {
                to--
            }

            if (from < to) {

                nums[from] = nums[to]
                nums[to] = `val`
            }
        }

        return from

    }

    fun removeElementDraft2(nums: IntArray, `val`: Int): Int {

        var kDestination = nums.size-1;
        var i = 0
        while (i < kDestination+1) {
            while (nums[i] == `val` && kDestination > -1) {
                val kDestValue = nums[kDestination]
                nums[kDestination] = `val`
                nums[i] = kDestValue
                kDestination--
            }
            i++
        }
        return kDestination +1;

    }

    fun removeElementDraft1(nums: IntArray, `val`: Int): Int {

        var prevFilled = 0
        var filledEnd = 0
        var filledCount = 0
        var firstTime = true

        var i = nums.size -1
        while (i >= 0) {

            if (nums[i] == `val`) {

                val kEnd = i
                var k = i

                try {
                    while (nums[k] == `val`) {
                        k--
                    }
                } catch (e: Exception) {
                    k = -1
                }
                val kBegin = k+1
                i = kBegin-1

                if (kEnd != nums.size -1) {
                    nums.copyInto(nums, destinationOffset = kBegin, startIndex = kEnd +1, endIndex = filledEnd +1)  // passed in wrong arg for endIndex (as filledEnd; instead of filledEnd+1)
                }

            }  else {

                if (firstTime) {  // didn't think this through the first time
                    filledEnd = i
                    firstTime = false
                } else {
                    if (prevFilled != i+1) {
                        filledEnd = i
                    }
                }

                prevFilled = i
                filledCount ++
                i--
            }

        }

        return filledCount

    }

}