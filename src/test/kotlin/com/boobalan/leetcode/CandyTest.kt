package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.Candy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CandyTest {

    @Test
    fun candyCase1() {
        val candy = Candy().candy(intArrayOf(1, 0, 2))
        Assertions.assertEquals(5, candy)
    }

    @Test
    fun candyCase2() {
        val candy = Candy().candy(intArrayOf(1, 2, 2))
        Assertions.assertEquals(4, candy)
    }

    @Test
    fun candyCase3() {
        val candy = Candy().candy(intArrayOf(1, 2, 2, 3, 7, 6, 5, 5, 9, 3, 7))
        Assertions.assertEquals(18, candy)
    }

    @Test
    fun candyCase4() {
        val candy = Candy().candy(intArrayOf(1, 2, 2, 3, 7, 6, 5, 4, 4, 4, 5, 9, 3, 7))
        Assertions.assertEquals(31, candy)
    }
}