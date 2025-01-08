package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Minimum Window Substring Test` {

    @Test
    fun minWindowCase1() {
        val minWindow = `Minimum Window Substring`().minWindow("ADOBECODEBANC", "ABC")
        assertEquals("BANC", minWindow)
    }

    @Test
    fun minWindowCase2() {
        val minWindow = `Minimum Window Substring`().minWindow("a", "a")
        assertEquals("a", minWindow)
    }

    @Test
    fun minWindowCase3() {
        val minWindow = `Minimum Window Substring`().minWindow("a", "aa")
        assertEquals("", minWindow)
    }
}