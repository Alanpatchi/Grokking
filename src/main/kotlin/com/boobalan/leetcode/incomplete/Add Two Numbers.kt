package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.ListNode

class `Add Two Numbers` {

    fun addTwoNumbersWronglyInterpretedTheQuestion(l1: ListNode?, l2: ListNode?): ListNode? {

        var p1 = l1
        var p2 = l2
        while (p1!!.next != null && p2!!.next != null) {
            p1 = p1.next
            p2 = p2.next
        }

        var longerRowHead = if (p1.next == null) l2 else l1
        var shorterRowHead = if (p1.next == null) l1 else l2

        var longerRowPointer =  if (p1.next == null) p2 else p1

        var delta = 0
        while (longerRowPointer?.next != null) {
            longerRowPointer = longerRowPointer.next
            delta++
        }


        var returnListPointer = longerRowHead
        for (i in 0 until delta) {
            returnListPointer = returnListPointer!!.next
        }

        var carry = 0
        var previousPointer = returnListPointer
        while (returnListPointer != null) {
            val sum = returnListPointer.`val` + shorterRowHead!!.`val` + carry
            returnListPointer.`val` = sum % 10
            carry = sum / 10
            previousPointer = returnListPointer
            returnListPointer = returnListPointer.next
            shorterRowHead = shorterRowHead.next
        }

        if (carry != 0) {
            previousPointer!!.next = ListNode(carry)
        }

        return longerRowHead
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var p1 = l1
        var p2 = l2
        var carry = 0
        var prevP1: ListNode? = null
        var prevP2: ListNode? = null
        while (p1 !=null && p2 != null) {
            val sum = p1.`val` + p2.`val` + carry
            p1.`val` = sum % 10
            carry = sum / 10
            prevP2 = p2
            prevP1 = p1
            p1 = p1.next
            p2 = p2.next
        }


        var remainingChainCursor = if (p1 == null) {
            prevP1!!.next = p2
            p2
        } else {
            p1
        }

        var remainingChainCursorPreviousNode = prevP1

        while (remainingChainCursor != null) {
            val sum = remainingChainCursor.`val` + carry
            remainingChainCursor.`val` = sum % 10
            carry = sum / 10
            remainingChainCursorPreviousNode = remainingChainCursor
            remainingChainCursor = remainingChainCursor.next
        }

        if (carry != 0) {
            remainingChainCursorPreviousNode!!.next = ListNode(carry)
        }

        return l1
    }
}