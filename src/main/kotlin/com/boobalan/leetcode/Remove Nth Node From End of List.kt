package com.boobalan.leetcode

/**
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150
 *  Pattern: 2 pointers
 */
class `Remove Nth Node From End of List` {


    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var aheadNode = head

        val behindToAheadNodeGap = n-1
        var aheadNodePosition = 0
        while (aheadNodePosition < behindToAheadNodeGap) {
            if (aheadNode == null) {
                return head
            }
            aheadNode = aheadNode.next
            aheadNodePosition++
        }
        var behindNode = head

        if (aheadNode == null) {
            return head
        }


        if (aheadNode.next == null) {
            return behindNode?.next
        } else {
            aheadNode = aheadNode.next
            var parentNodeToBehindNode = behindNode
            behindNode = behindNode?.next

            while (aheadNode?.next != null) {
                aheadNode = aheadNode?.next
                parentNodeToBehindNode = parentNodeToBehindNode?.next
                behindNode = behindNode?.next
            }

            parentNodeToBehindNode?.next = behindNode?.next
            return head
        }
    }
}