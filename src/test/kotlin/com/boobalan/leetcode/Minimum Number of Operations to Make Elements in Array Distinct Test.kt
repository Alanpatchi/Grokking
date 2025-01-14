package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.challenge.`Minimum Number of Operations to Make Elements in Array Distinct`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Minimum Number of Operations to Make Elements in Array Distinct Test` {

    @Test
    fun minimumOperationsSample1() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(
                1,
                2,
                3,
                4,
                2,
                3,
                3,
                5,
                7
            )
        )
        assertEquals(2, minimumOperations)
    }

    @Test
    fun minimumOperationsSample2() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(
                4,5,6,4,4
            )
        )
        assertEquals(2, minimumOperations)
    }

    @Test
    fun minimumOperationsSample3() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(
                6,7,8,9
            )
        )
        assertEquals(0, minimumOperations)
    }
    @Test
    fun minimumOperationsSample4() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(
            )
        )
        assertEquals(0, minimumOperations)
    }


    @Test
    fun minimumOperationsSample5() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(11,3,9,14,1

            )
        )
        assertEquals(0, minimumOperations)
    }

    @Test
    fun minimumOperationsSample6() {
        val minimumOperations = `Minimum Number of Operations to Make Elements in Array Distinct`().minimumOperations(
            intArrayOf(3,7,7,3

            )
        )
        assertEquals(1, minimumOperations)
    }
}