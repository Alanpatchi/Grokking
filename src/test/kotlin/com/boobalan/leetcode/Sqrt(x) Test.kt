package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Sqrt(x) Test` {

    @Test
    fun mySqrtCase1() {
        val mySqrt = `Sqrt(x)`().mySqrt(8)
        assertEquals(2, mySqrt)
    }

    @Test
    fun mySqrtCase2() {
        val mySqrt = `Sqrt(x)`().mySqrt(2147395600)
        assertEquals(46340, mySqrt)
    }



}