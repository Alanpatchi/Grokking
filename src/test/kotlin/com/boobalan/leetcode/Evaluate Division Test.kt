package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Evaluate Division`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class `Evaluate Division Test` {

    @Test
    fun calcEquationSample1() {
        val calcEquation: DoubleArray = `Evaluate Division`().calcEquation(
            listOf(
                listOf("a", "b"), listOf("b", "c")
            ),
            doubleArrayOf(2.0, 3.0),
            listOf(
                listOf("a", "c"),
                listOf("b", "a"),
                listOf("a", "e"),
                listOf("a", "a"),
                listOf("x", "x")
            )
        )
        assertThat(calcEquation.toList(), Matchers.contains(6.00000,0.50000,-1.00000,1.00000,-1.00000))
    }
}