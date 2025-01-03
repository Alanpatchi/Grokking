package com.boobalan.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class `3SumTest` {

    @Test
    fun twoSumCase1() {
        val array = intArrayOf(-1,0,1,2,-1,-4)
        val twoSum = `3Sum`().threeSum(array)
        assertThat(twoSum, Matchers.hasSize(2))
        assertThat(twoSum[0], Matchers.contains(-1,-1,2))
        assertThat(twoSum[1], Matchers.contains(-1, 0, 1))
    }

    @Test
    fun twoSumCase2() {
        val array = intArrayOf(0, 1, 1)
        val twoSum = `3Sum`().threeSum(array)
        assertThat(twoSum, Matchers.empty())
    }

    @Test
    fun twoSumCase3() {
        val array = intArrayOf(0,0,0)
        val twoSum = `3Sum`().threeSum(array)
        assertThat(twoSum, Matchers.hasSize(1))
        assertThat(twoSum[0], Matchers.contains(0, 0, 0))
    }


}