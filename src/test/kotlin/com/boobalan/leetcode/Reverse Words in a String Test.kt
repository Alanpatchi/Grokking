package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Reverse Words in a String Test` {

    @Test
    fun reverseWordsCase1() {
        val reverseWords = `Reverse Words in a String`().reverseWords("the sky is blue")
        assertEquals("blue is sky the", reverseWords)
    }
}