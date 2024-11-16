package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Add Two Numbers`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Add Two Numbers Test` {

    @Test
    fun addTwoNumbersTest() {

        val l1 = ListNode(2)
        l1.next = ListNode(4)
        l1.next!!.next = ListNode(3)

        val l2 = ListNode(5)
        l2.next = ListNode(6)
        l2.next!!.next = ListNode(4)

        val addTwoNumbers = `Add Two Numbers`().addTwoNumbers(l1, l2)
        Assertions.assertEquals(7, addTwoNumbers!!.`val`)
        Assertions.assertEquals(0, addTwoNumbers.next!!.`val`)
        Assertions.assertEquals(8, addTwoNumbers.next!!.next!!.`val`)

    }

}