package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Integer to Roman Test` {

    @Test
    fun intToRomanCase1() {
        val intToRoman = `Integer to Roman`().intToRoman(3749)
        assertEquals("MMMDCCXLIX", intToRoman)
    }
}