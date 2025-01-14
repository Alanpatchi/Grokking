package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.challenge.`Button with Longest Push Time`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Button with Longest Push Time Test` {

    @Test
    fun buttonWithLongestTimeSample1() {
        val buttonWithLongestTime = `Button with Longest Push Time`().buttonWithLongestTime(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 5),
                intArrayOf(3, 9),
                intArrayOf(1, 15)
            )
        )
        assertEquals( 1, buttonWithLongestTime)
    }

    @Test
    fun buttonWithLongestTimeSample2() {
        val buttonWithLongestTime = `Button with Longest Push Time`().buttonWithLongestTime(
            arrayOf(
                intArrayOf(10, 5),
                intArrayOf(1, 7),
            )
        )
        assertEquals( 10, buttonWithLongestTime)
    }

    @Test
    fun buttonWithLongestTimeSample3() {
        val buttonWithLongestTime = `Button with Longest Push Time`().buttonWithLongestTime(
            arrayOf(
                intArrayOf(9,4),
                intArrayOf(19,5),
                intArrayOf(2,8),
                intArrayOf(3,11),
                intArrayOf(2,15),
            )
        )
        assertEquals( 2, buttonWithLongestTime)
    }
}