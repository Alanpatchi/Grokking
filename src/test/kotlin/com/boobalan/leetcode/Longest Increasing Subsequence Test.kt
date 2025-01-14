package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class `Longest Increasing Subsequence Test` {

    @Test
    fun lengthOfLISCase1() {
        val lengthOfLIS = `Longest Increasing Subsequence`().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))
        assertEquals(4, lengthOfLIS)
    }
}