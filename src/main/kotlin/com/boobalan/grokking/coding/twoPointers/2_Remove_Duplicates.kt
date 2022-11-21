package com.boobalan.grokking.coding.twoPointers

import kotlin.math.max

fun main(args: Array<String>) {
    var input = intArrayOf(2,3,3,3,6,9,9)
    var p1 = 0
    var p2 = 0

    while (p2 < input.size) {
        var prevP2 = p2

        do {
            p2++
        } while (p2 < input.size && input[p2-1] == input[p2])

        input[p1] = input[prevP2]

        for (i in max(p1 +1, prevP2) until p2) {
            input[i] = 0
        }

        p1++
    }

    println(input.contentToString())
}