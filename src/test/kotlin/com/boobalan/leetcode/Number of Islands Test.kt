package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Number of Islands Test` {

    @Test
    fun testNumOfIslands() {

        Assertions.assertEquals(1, `Number of Islands`().numIslands(arrayOf(charArrayOf('1','1','1','1','0'), charArrayOf('1','1','0','1','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','0','0','0'))))
        Assertions.assertEquals(3, `Number of Islands`().numIslands(arrayOf(charArrayOf('1','1','0','0','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','1','0','0'), charArrayOf('0','0','0','1','1'))))
    }
}