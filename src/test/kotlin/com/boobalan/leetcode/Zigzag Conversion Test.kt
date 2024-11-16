package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Zigzag Conversion`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Zigzag Conversion Test` {

    @Test
    fun convertTestSample1() {
        Assertions.assertEquals("PAHNAPLSIIGYIR", `Zigzag Conversion`().convert("PAYPALISHIRING", 3))
    }
}