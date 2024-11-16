package com.boobalan.grokking.leetcode

private class ReverseIntegerSolution {
    fun reverse(x: Int): Int {

//        if (x == Int.MIN_VALUE ) {
//            return 0
//        }

        val isNegative = (x < 0)
        var input = if (isNegative) {
            -x
        } else {
            x
        }

        var output = 0

        while (input > 0) {
            if (output > Int.MAX_VALUE / 10) {
                return 0
            }
            output *=10
            output += input % 10
            input /= 10
        }

        output = if (isNegative) {
            -output;
        } else {
            output
        }
        return  output;
    }

}

fun main(args: Array<String>) {
    println(ReverseIntegerSolution().reverse(123))

    println(ReverseIntegerSolution().reverse(1534236469))
}