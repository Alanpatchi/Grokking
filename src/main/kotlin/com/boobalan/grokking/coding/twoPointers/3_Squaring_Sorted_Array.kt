package com.boobalan.grokking.coding.twoPointers

import kotlin.math.abs

fun main(args: Array<String>) {
    val solution = `3_Squaring_Sorted_Array`()
    var result = solution.makeSquares(intArrayOf(-2, -1, 0, 2, 3))
    println(result.contentToString())

    println()
    result = solution.makeSquares(intArrayOf(-3, -1, 0, 1, 2))

    println(result.contentToString())

}

class `3_Squaring_Sorted_Array` {


    fun makeSquares(arr: IntArray): IntArray {
        val n = arr.size

        var lp = 0
        var rp = n -1

        var output = IntArray(n)

        /**
        if lp and rp arr values are both +ve
        return arr^2
        if lp and rp values are both -ve return inverted arr square
        if both are opposite sign,
        set lp = 0; rp = n-1 and; set new array from n-1 to 0 with max of arr of abs values at lp and rp; move lp and rp accordingly (if lp then lp++; if rp then rp--)
        **/

        if (arr[0] >= 0) {
            for (i in 0 until n) {
                output[i] = arr[i] * arr[i]
            }
            return output
        }

        if (arr[n -1] <=0) {
            for (i in 0 until n) {
                output[n -i] = arr[i] * arr[i]
            }
            return output
        }

        var outputIndex = n -1
        while (rp >= lp) {
//            println("current lp: $lp and rp: $rp")
            if (abs(arr[lp]) <= abs(arr[rp])) {
                output[outputIndex--] = arr[rp] * arr[rp]
                rp--
            } else {
                output[outputIndex--] = arr[lp] * arr[lp]
                lp++
            }
        }




        return output
    }
}