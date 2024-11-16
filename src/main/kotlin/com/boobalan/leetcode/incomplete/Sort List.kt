package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.ListNode

class `Sort List` {

    /**
     * TODO implement using merge-sort
      */
    fun sortList(head: ListNode?): ListNode? {

        if (head == null) {
            return null
        }
        var currentSortedLinkEnd = head
        var currentHeadNode = head
        while (currentSortedLinkEnd != null) {
            val newNode = currentSortedLinkEnd.next
            val nextElement = newNode?.next
            if (newNode != null) {
                var cursorNode = currentHeadNode
                var cursorParentNode: ListNode? = null
                while (cursorParentNode != currentSortedLinkEnd) {

                    if (newNode.`val` > cursorNode!!.`val`) {
                        cursorParentNode = cursorNode
                        cursorNode = cursorNode.next
                    } else {
                        break
                    }
                }
                if (cursorParentNode == currentSortedLinkEnd) {
                    currentSortedLinkEnd = newNode
                }
                if (cursorParentNode == null) {
                    currentHeadNode = newNode
                }
                cursorParentNode?.next = newNode
                newNode.next = cursorNode

                currentSortedLinkEnd.next = nextElement


            } else {
                currentSortedLinkEnd = null
            }

        }
        return currentHeadNode
    }
//        fun sortList(head: ListNode?): ListNode? {
//
//        }

}