package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Word Ladder`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Word Ladder Test` {

    @Test
    fun wordLadderTestSample1() {
        val ladderLength = `Word Ladder`().ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
        Assertions.assertEquals(5, ladderLength)
    }

    @Test
    fun wordLadderTestSample2() {
        val ladderLength = `Word Ladder`().ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log"))
        Assertions.assertEquals(0, ladderLength)
    }
}