package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Single Number II Test` {

    @Test
    fun testSingleNumber() {

//        Assertions.assertEquals(3, `Single Number II`().singleNumber(intArrayOf(2,2,3,2)))
        Assertions.assertEquals(99, `Single Number II`().singleNumber(intArrayOf(0,1,0,1,0,1,99)))

    }
}