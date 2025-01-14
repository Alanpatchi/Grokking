package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.ListNode

class `Reverse Linked List II` {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        val oneBeforeLeft: ListNode?
        val oneAfterRight: ListNode?
        val leftNode: ListNode
        val rightNode: ListNode

        var cursor: Int = 1
        var cursorNode = head
        var oneBefore: ListNode? = null
        while (cursor != left) {
            cursor++
            oneBefore = cursorNode
            cursorNode = cursorNode?.next
        }
        oneBeforeLeft = oneBefore
        leftNode = cursorNode!!


        while (cursor != right) {
            cursor++
            oneBefore = cursorNode
            cursorNode = cursorNode?.next
        }

        rightNode = cursorNode!!
        oneAfterRight = rightNode.next

        reverse(leftNode, rightNode)
        leftNode.next = oneAfterRight
        oneBeforeLeft?.next = rightNode

        return if (left == 1) {
            rightNode
        } else {
            head
        }
    }

    private fun reverse(leftNode: ListNode, rightNode: ListNode) {

        var cursorNode: ListNode? = leftNode
        var nextCursor: ListNode?
        var bufferNode: ListNode? = null
        val endNode = rightNode.next
        while (cursorNode != endNode) {
            nextCursor = cursorNode?.next
            cursorNode?.next = bufferNode

            bufferNode = cursorNode
            cursorNode = nextCursor
        }

    }

}