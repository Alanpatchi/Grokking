package com.boobalan.grokking.coding.sliding

import java.util.LinkedList

fun main(args: Array<String>) {

    val input = arrayOf(0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1)
    val k = 3

    var longestSubarrayStart = 0
    var longestSubarrayEnd = 0

    // fifo queue
    val zerosPosition = LinkedList<Int>()

    var s = 0 // alias windowStart
    var e = 0 // alias windowEnd

    try {
        while (e < input.size) {
            // reposition e
            do {
                val currentWindowEnd = input[e]
                if (currentWindowEnd == 0) {
                    zerosPosition.add(e)
                }
                e++
            } while (zerosPosition.size <= k)

            // recalculate
            if (longestSubarrayEnd - longestSubarrayStart + 1 < e -1 -s) {
                longestSubarrayStart = s
                longestSubarrayEnd = e-2
            }

            // reposition s
            s = zerosPosition.remove() +1
        }
    } catch (_: ArrayIndexOutOfBoundsException) {
        // recalculate
        if (longestSubarrayEnd - longestSubarrayStart + 1 < e -s) {
            longestSubarrayStart = s
            longestSubarrayEnd = e-1
        }
    }

    println("$longestSubarrayStart : ${longestSubarrayEnd -longestSubarrayStart +1} == ${input.copyOfRange(longestSubarrayStart, longestSubarrayEnd + 1).contentToString()}")


}