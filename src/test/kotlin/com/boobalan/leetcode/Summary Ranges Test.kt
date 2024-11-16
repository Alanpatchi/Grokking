package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Summary Ranges Test` {

    @Test
    fun summaryRangesTest() {

       Assertions.assertIterableEquals(listOf("0->2","4->5","7"), `Summary Ranges`().summaryRanges(intArrayOf(0,1,2,4,5,7)))

    }
}