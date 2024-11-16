package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Word Break Test` {

    @Test
    fun testWordBreak() {

        Assertions.assertTrue(`Word Break`().wordBreak("leetcode", listOf("leet","code")))
        Assertions.assertTrue(`Word Break`().wordBreak("applepenapple", listOf("apple","pen")))
        Assertions.assertFalse(`Word Break`().wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))


    }
}