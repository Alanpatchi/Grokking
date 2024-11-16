package com.boobalan.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.comparesEqualTo
import org.junit.jupiter.api.Test

class `Factorial Trailing Zeroes Test` {

    @Test
    fun testTrailingZeroes() {
        assertThat(`Factorial Trailing Zeroes`().trailingZeroes(5), Matchers.`is`(1))
    }
}