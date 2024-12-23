package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.ListNode

class `Reverse Nodes in k-Group` {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        var (kMoreElements, lastNodeOfK) = checkIfThereAreKMoreElements(head, k)

        // init for k span
        var prev: ListNode? = null
        var beforeKNode: ListNode?
        var firstNodeOfK: ListNode?
        var afterKNode: ListNode?

        val wasThereAtleastOneKSpan = kMoreElements
        val theNewHead = if (wasThereAtleastOneKSpan) lastNodeOfK else head



        while (kMoreElements) {
            // init
            if (prev != null) {
                beforeKNode = prev
            } else {
                beforeKNode = null
            }

            if (beforeKNode != null) {
                firstNodeOfK = beforeKNode.next
            } else {
                firstNodeOfK = head
            }

            afterKNode = lastNodeOfK?.next

            // swap pointers in K span
            var cursor: ListNode? = firstNodeOfK
            var next: ListNode?
            var swapPointerActionCount = 0
            while (swapPointerActionCount < k) {
                next = cursor!!.next
                cursor.next = prev
                prev = cursor
                cursor = next
                swapPointerActionCount++
            }

            // set pointers at the beginning and end of K
            beforeKNode?.next = prev
            firstNodeOfK!!.next = afterKNode

            // set things up for next iteration
            val (kMore, lastNodeOfNextK) = checkIfThereAreKMoreElements(afterKNode, k)
            prev = firstNodeOfK
            kMoreElements = kMore
            lastNodeOfK = lastNodeOfNextK

        }

        return theNewHead


    }

    /**
     * returns the last Node of K if there are k elements
     */
    private fun checkIfThereAreKMoreElements(head: ListNode?, k: Int): Pair<Boolean, ListNode?> {

        var cursorNode = head
        var nodeCount = 1
        while (nodeCount < k) {

            if (cursorNode == null) {
                return false to null
            } else {
                cursorNode = cursorNode.next
                nodeCount++
            }
        }
        return if (nodeCount == k && cursorNode != null) {
            true to cursorNode
        } else {
            false to null
        }


    }

}