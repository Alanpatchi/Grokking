package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Snakes and Ladders Test` {

    @Test
    fun snakesAndLaddersCase1() {
        val snakesAndLadders = `Snakes and Ladders`().snakesAndLadders(
            arrayOf(
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 35, -1, -1, 13, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 15, -1, -1, -1, -1),
            )

        )
        assertEquals(4, snakesAndLadders)
    }

    @Test
    fun snakesAndLaddersCase2() {
        val snakesAndLadders = `Snakes and Ladders`().snakesAndLadders(
            arrayOf(
                intArrayOf(-1, -1),
                intArrayOf(-1, 3)
            )

        )
        assertEquals(1, snakesAndLadders)
    }
}