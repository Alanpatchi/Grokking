package com.boobalan.leetcode

import kotlin.math.min

class `Factorial Trailing Zeroes` {

    fun trailingZeroes(n: Int): Int {

        var i = 2
        var twoCount = 0
        while (i <= n) {
            twoCount += n / i
            i = i shl 1
        }
        i = 5
        var fiveCount = 0
        while (i <= n) {
            fiveCount += n / i
            i *= 5
        }

        return min(twoCount, fiveCount)
    }
}