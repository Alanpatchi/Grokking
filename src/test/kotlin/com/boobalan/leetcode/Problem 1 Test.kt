package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.challenge.`Problem 1`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Problem 1 Test` {

    @Test
    fun problem1Case1() {
        val minimumOperations = `Problem 1`().minimumOperations(
            arrayOf(
                intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(3, 4), intArrayOf(0, 1)
            )
        )
        assertEquals(15, minimumOperations)
    }

    @Test
    fun problem1Case2() {
        val minimumOperations = `Problem 1`().minimumOperations(
            arrayOf(
                intArrayOf(3, 2, 1), intArrayOf(2, 1, 0), intArrayOf(1, 2, 3)
            )
        )
        assertEquals(12, minimumOperations)

    }

    @Test
    fun problem1Case3() {

    }

    @Test
    fun problem1Case4() {

    }
}