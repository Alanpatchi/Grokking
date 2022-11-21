package com.boobalan.grokking.coding.twoPointers

import kotlin.math.max

fun main(args: Array<String>) {
    var input = intArrayOf(2,2,2,11)
    var p1 = 0
    var p2 = 0

    while (p2 < input.size) {
        var temp = input[p2]

        do {
            var value = input[p2]
            input[p2] = 0
            p2++
        } while (p2 < input.size && value == input[p2])

        input[p1++] = temp;


    }


    println(input.contentToString())
}