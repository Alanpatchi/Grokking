package com.boobalan.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.AnyOf
import org.hamcrest.core.AnyOf.anyOf
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsEqual.equalTo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Find Peak Element Test` {

    @Test
    fun findPeakElementCase1() {
        val findPeakElement = `Find Peak Element`().findPeakElement(intArrayOf(1, 2, 3, 1))
        assertEquals(2, findPeakElement)
    }

    @Test
    fun findPeakElementCase2() {
        val findPeakElement = `Find Peak Element`().findPeakElement(intArrayOf(1,2,1,3,5,6,4))
        assertThat(findPeakElement, anyOf(equalTo(1), equalTo(5)))
    }
}