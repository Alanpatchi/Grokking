package com.boobalan.leetcode

import org.junit.jupiter.api.Test

class `Partition List Test` {

    @Test
    fun testPartition() {
        val nodeValues = intArrayOf(1, 4, 3, 2, 5, 2)

        var prevNode: ListNode? = null
        var headNode: ListNode? = null
        for (i in nodeValues) {
            val listNode = ListNode(i)
            if (headNode == null) { headNode = listNode }
            if (prevNode != null) { prevNode.next = listNode }
            prevNode = listNode
        }

        `Partition List`().partition(headNode, 3)


    }
}