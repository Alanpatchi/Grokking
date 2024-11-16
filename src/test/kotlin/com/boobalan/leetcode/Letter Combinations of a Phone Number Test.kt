package com.boobalan.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Letter Combinations of a Phone Number Test` {

    @Test
    fun testLetterCombinations() {

        assertThat(`Letter Combinations of a Phone Number`().letterCombinations("23"), containsInAnyOrder(
            "ad","ae","af","bd","be","bf","cd","ce","cf"
        ))

        assertThat(`Letter Combinations of a Phone Number`().letterCombinations(""), hasSize(0))

        assertThat(`Letter Combinations of a Phone Number`().letterCombinations("2"), containsInAnyOrder(
            "a","b","c"
        ))

    }
}