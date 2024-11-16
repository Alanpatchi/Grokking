package com.boobalan.leetcode

class `Climbing Stairs` {

    fun climbStairs(n: Int): Int {

        val array = IntArray(n+1)
        array[0] = 1
        array[1] = 1
        for (i in 2 until array.size) {
            array[i] = array[i-1] + array[i-2]
        }
        return array[n]

    }
}