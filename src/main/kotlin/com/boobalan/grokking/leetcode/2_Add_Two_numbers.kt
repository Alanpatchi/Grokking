package com.boobalan.grokking.leetcode

class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var carry = 0
    var returnNode: ListNode? = null
    var previousNode: ListNode? = null

    var l1CursorNode: ListNode? = l1
    var l2CursorNode: ListNode? = l2

    while (l1CursorNode != null || l2CursorNode != null || carry != 0) {

        val sum = (l1CursorNode?.`val` ?: 0) + (l2CursorNode?.`val` ?: 0) + carry
        carry = sum.div(10)
        val currentNode = ListNode(sum.rem(10))
        if (returnNode == null) {
            returnNode = currentNode
        }
        previousNode?.also {
            it.next = currentNode
        }

        previousNode = currentNode
        l1CursorNode = l1CursorNode?.next
        l2CursorNode = l2CursorNode?.next
    }

    return returnNode


}

fun main(args: Array<String>) {

}