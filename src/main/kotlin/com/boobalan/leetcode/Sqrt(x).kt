package com.boobalan.leetcode

import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt

class `Sqrt(x)` {

    fun mySqrt(x: Int): Int {

        if (x == 0 || x == 1) {
            return x
        } else {
            var end = min((x / 2) + 1, 46341)
            var begin = 0
            while (end - begin > 1) {
                val middle = (end + begin) / 2
                val middleSquared = middle * middle
                when  {
                    middleSquared == x -> return middle
                    middleSquared < x -> begin = middle
                    else -> end = middle
                }
            }
            return begin
        }
    }
}