package com.boobalan.leetcode



class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class `Linked List Cycle` {

    fun hasCycle(head: ListNode?): Boolean {
        var pointer = head
        var fastPointer = head

        var isCyclicPath = false
        while(fastPointer != null) {
            pointer = pointer?.next
            fastPointer = fastPointer.next?.next
            if (pointer != null && fastPointer == pointer) {
                isCyclicPath = true
                break
            }
        }
        return isCyclicPath

    }
}