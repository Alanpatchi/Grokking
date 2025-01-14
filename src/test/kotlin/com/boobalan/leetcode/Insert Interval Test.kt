package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class `Insert Interval Test` {

    @Test
    fun insertCase1() {
        val insert = `Insert Interval`().insert(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
            intArrayOf(4, 8)
        )
        assertArrayEquals(
            arrayOf(intArrayOf(1,2), intArrayOf(3,10), intArrayOf(12,16)), insert
        )
    }

    @Test
    fun insertCase2() {
        val insert = `Insert Interval`().insert(
            arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
            intArrayOf(2, 5)
        )
        assertArrayEquals(
            arrayOf(intArrayOf(1,5), intArrayOf(6,9)), insert
        )
    }

    @Test
    fun insertCase3() {
        val insert = `Insert Interval`().insert(
            arrayOf(intArrayOf(1, 3), intArrayOf(6, 8), intArrayOf(9, 9)),
            intArrayOf(7, 8)
        )
        assertArrayEquals(
            arrayOf(intArrayOf(1, 3), intArrayOf(6, 8), intArrayOf(9, 9)), insert
        )
    }
}