package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Reverse Linked List II`
import org.junit.jupiter.api.Test

class `Reverse Linked List II Test` {

    @Test
    fun reverseBetweenTest() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next?.next = ListNode(4)
        head.next!!.next?.next?.next = ListNode(5)
        val reversed = `Reverse Linked List II`().reverseBetween(head, 2, 4)
        println(reversed)

    }
}