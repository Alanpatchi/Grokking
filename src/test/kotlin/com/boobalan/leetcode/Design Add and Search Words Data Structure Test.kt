package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Design Add and Search Words Data Structure Test` {

    @Test
    fun addAndSearchWord() {
        val db = `Design Add and Search Words Data Structure`()

        db.addWord("bad")
        db.addWord("dad")
        db.addWord("mad")
        assertTrue(db.search("bad"))
        assertTrue(db.search(".ad"))
        assertTrue(db.search("b.."))
    }
}