package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Course Schedule  Test` {

    @Test
    fun canFinishCase1() {
        assertTrue(`Course Schedule`().canFinish(2, arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun canFinishCase2() {
        assertFalse(`Course Schedule`().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }
}