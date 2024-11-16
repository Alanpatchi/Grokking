package com.boobalan.leetcode

/**
 * Pattern: 2 pointers to track the backPos and frontPos
 * https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
 */
class `Rotate List` {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        var backPos = -k
        var frontPos = 0

        if (head == null)
            return null

        var backNode: ListNode? = if (backPos == 0) head else null
        var node = head
        while (node?.next != null) {

            backPos++
            frontPos++
            backNode = if (backPos == 0) head else backNode?.next
            node = node.next
        }



        if (backPos > -1) {

            node?.next = head
            val newHead = backNode?.next
            backNode?.next = null
            return newHead

        } else {

            val n = frontPos + 1
            val tailPosition = Math.floorMod(n - 1 - k, n)
            var pos = 0
            var node1 = head
            while (pos != tailPosition) {
                node1 = node1?.next
                pos++
            }
            node?.next = head
            val newHead = node1?.next
            node1?.next = null
            return newHead

        }

    }

}