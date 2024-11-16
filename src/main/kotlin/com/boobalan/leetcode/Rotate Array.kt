package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
class `Rotate Array` {

    fun rotate(nums: IntArray, k: Int): Unit {

        val arrayLength = nums.size

        val rotateGap = Math.floorMod(k, arrayLength)

        val fifo = ArrayDeque<Int>(rotateGap)

        var numsIndex = 0
        while (fifo.size != rotateGap) {
            fifo.add(nums[numsIndex++])
        }

        var rotatedCount = 0

        if (fifo.isNotEmpty()) {
            while (rotatedCount != arrayLength) {

                numsIndex = Math.floorMod(numsIndex, arrayLength)

                val element = nums[numsIndex]
                nums[numsIndex] = fifo.removeFirst()
                fifo.add(element)
                rotatedCount++
                numsIndex++

            }
        }




    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1,2,3,4,5,6,7)
    `Rotate Array`().rotate(nums, 3)

    println(nums.contentToString())
}