package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Word Search`
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Word Search Test` {

    @Test
    fun existSample1() {
        val exist = `Word Search`().exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "ABCCED"
        )
        assertTrue(exist)
    }


    @Test
    fun existSample2() {
        val exist = `Word Search`().exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "SEE"
        )
        assertTrue(exist)
    }
    @Test
    fun existSample3() {
        val exist = `Word Search`().exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "ABCB"
        )
        assertFalse(exist)
    }

    @Test
    fun existSample4() {
        val exist = `Word Search`().exist(
            arrayOf(
                charArrayOf('A', 'B')
            ),
            "BA"
        )
        assertTrue(exist)
    }

}