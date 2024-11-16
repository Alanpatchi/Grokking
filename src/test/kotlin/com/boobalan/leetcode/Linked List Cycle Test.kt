package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 * algo: 2 pointers (slow and fast)
 */
class `Linked List Cycle Test` {

    @Test
    fun testHasCycle() {
        val node2 = ListNode(2)
        val node1 = ListNode(1)
        node2.next = node1
        node1.next = node2
        Assertions.assertTrue(`Linked List Cycle`().hasCycle(node1))
    }

    @Test
    fun testHasCycleForAnotherTestCase() {
        val node3 = ListNode(3)
        val node2 = ListNode(2)
        node3.next = node2
        val node0 = ListNode(0)
        node2.next = node0
        val `node-4` = ListNode(4)
        node0.next = `node-4`
        `node-4`.next = node2
        Assertions.assertTrue(`Linked List Cycle`().hasCycle(node0))
    }

    @Test
    fun testHasNoCycle() {
        Assertions.assertFalse(`Linked List Cycle`().hasCycle(ListNode(1)))
    }
}