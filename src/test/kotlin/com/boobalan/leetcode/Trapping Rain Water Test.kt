package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Trapping Rain Water Test` {

    @Test
    fun trapTest() {
        Assertions.assertEquals(6, `Trapping Rain Water`().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
        Assertions.assertEquals(9, `Trapping Rain Water`().trap(intArrayOf(4,2,0,3,2,5)))
    }
}