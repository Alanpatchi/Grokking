package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Jump Game II Test` {

    @Test
    fun jump() {
        val jump = `Jump Game II`().jump(intArrayOf(2, 3, 1, 1, 4))
        assertEquals(2, jump)
    }
}