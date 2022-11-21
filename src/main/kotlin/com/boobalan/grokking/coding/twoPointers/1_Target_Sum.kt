package com.boobalan.grokking.coding.twoPointers

fun main(args: Array<String>) {
    var input = intArrayOf(1,2,3,4,6)
    var target = 6

    var lp = 0
    var rp = input.size - 1

    var result: IntArray? = null

    while (rp >= lp) {

        if (input[lp] + input[rp] > target) {
            rp--
        } else if (input[lp] + input[rp] < target) {
            lp++
        } else {
            result = intArrayOf(lp, rp)
            break
        }

    }

    if (result != null) {
        println("\"$lp:${input[lp]} and $rp:${input[rp]}\"")
    } else {
        println("\"\"")
    }
}