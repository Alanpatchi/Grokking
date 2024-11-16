package com.boobalan.leetcode

import org.junit.jupiter.api.Test

class `Rotate List Test` {

    @Test
    fun testRotateRight() {
        val one = ListNode(1)
        one.next = ListNode(2)

        `Rotate List`().rotateRight(one, 1)

    }
}