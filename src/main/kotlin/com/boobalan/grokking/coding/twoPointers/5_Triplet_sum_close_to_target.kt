package com.boobalan.grokking.coding.twoPointers

import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main(args: Array<String>) {
    val input = intArrayOf(0, 0, 1, 1, 2, 6)
    Arrays.sort(input)
    val target =5

    var minDel: Int = Int.MAX_VALUE
    var minSum: Int = Int.MAX_VALUE
    for (i in 0 until input.size-2) {
        var j = i + 1
        var k = input.size -1

        innerLoop@
        while (j < input.size && k < input.size && j < k) {
            val sum = input[i] + input[j] + input[k]
            val del = abs(target - sum)
            if ( del <= minDel)     {
                minSum = when (del) {
                    minDel -> min(minSum, sum)
                    else -> sum
                }
                minDel = del
            }
            if (sum < target) {
                j++
            } else if (sum > target) {
                k--
            } else {
                break@innerLoop
            }
        }


    }

    println(minSum)
}