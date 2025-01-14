package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.challenge.`Problem 2`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Problem 2 Test` {

    @Test
    fun problem2Case1() {
        val answerString = `Problem 2`().answerString("dbca", 2)
        assertEquals("dbc", answerString)
    }

    @Test
    fun problem2Case2() {
        val answerString = `Problem 2`().answerString("gggg", 4)
        assertEquals("g", answerString)
    }

    @Test
    fun problem2Case3() {
        val answerString = `Problem 2`().answerString("aann", 2)
        assertEquals("nn", answerString)
    }

    @Test
    fun problem2Case4() {
        val answerString = `Problem 2`().answerString("gh", 1)
        assertEquals("gh", answerString)
    }
}