package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Word Pattern Test` {

    @Test
    fun wordPatternCase1() {
        val wordPattern = `Word Pattern`().wordPattern("abba", "dog cat cat dog")
        assertTrue(wordPattern)
    }

    @Test
    fun wordPatternCase2() {
        val wordPattern = `Word Pattern`().wordPattern("abba", "dog cat cat fish")
        assertFalse(wordPattern)
    }

    @Test
    fun wordPatternCase3() {
        val wordPattern = `Word Pattern`().wordPattern("aaaa", "dog cat cat dog")
        assertFalse(wordPattern)
    }

    @Test
    fun wordPatternCase4() {
        val wordPattern = `Word Pattern`().wordPattern("abb", "dog cat cat dog")
        assertFalse(wordPattern)
    }

    @Test
    fun wordPatternCase5() {
        val wordPattern = `Word Pattern`().wordPattern("abbab", "dog cat cat dog")
        assertFalse(wordPattern)
    }

    @Test
    fun wordPatternCase6() {
        val wordPattern = `Word Pattern`().wordPattern("abba", "dog dog dog dog")
        assertFalse(wordPattern)
    }
}