package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.Node
import com.boobalan.leetcode.incomplete.`Sort List`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Sort List Test` {

    @Test
    fun sortListSample1() {
        val head= ListNode(4)
        head.next = ListNode(2)
        head.next!!.next = ListNode(1)
        head.next!!.next!!.next = ListNode(3)
        val sortListHead = `Sort List`().sortList(head)
        Assertions.assertEquals(1, sortListHead!!.`val`)
        Assertions.assertEquals(2, sortListHead.next!!.`val`)
        Assertions.assertEquals(3, sortListHead.next!!.next!!.`val`)
        Assertions.assertEquals(4, sortListHead.next!!.next!!.next!!.`val`)

    }

    @Test
    fun sortListSample2() {
        val head= ListNode(-1)
        head.next = ListNode(5)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next = ListNode(0)
        val sortListHead = `Sort List`().sortList(head)
        Assertions.assertEquals(-1, sortListHead!!.`val`)
        Assertions.assertEquals(0, sortListHead.next!!.`val`)
        Assertions.assertEquals(3, sortListHead.next!!.next!!.`val`)
        Assertions.assertEquals(4, sortListHead.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, sortListHead.next!!.next!!.next!!.next!!.`val`)


    }
}