package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert.assertThat


class `Course Schedule II Test` {

    @Test
    fun testFindOrder() {
        Assertions.assertArrayEquals(intArrayOf(0, 1), `Course Schedule II`().findOrder(2, arrayOf(intArrayOf(1, 0))))

        assertThat(`Course Schedule II`().findOrder(2, arrayOf()).toList(), containsInAnyOrder(1, 0))
    }
}