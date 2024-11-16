package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.Combinations
import org.junit.jupiter.api.Test

class `Combinations Test` {

    @Test
    fun combineTest() {
        Combinations().combine(1, 1).forEach { it ->
            println(it.toIntArray().contentToString())
        }
    }

}