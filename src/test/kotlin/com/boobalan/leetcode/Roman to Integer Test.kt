package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Roman to Integer`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class `Roman to Integer Test` {

    @Test
    fun romanToIntTest1() {
        val romanToInt = `Roman to Integer`().romanToInt("III")
        assertEquals(3, romanToInt)
    }

    @Test
    fun romanToIntTest2() {
        val romanToInt = `Roman to Integer`().romanToInt("LVIII")
        assertEquals(58, romanToInt)
    }

    @Test
    fun romanToIntTest3() {
        val romanToInt = `Roman to Integer`().romanToInt("MCMXCIV")
        assertEquals(1994, romanToInt)
    }
}