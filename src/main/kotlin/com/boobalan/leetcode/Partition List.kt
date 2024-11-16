package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Algo: tracking pointer
 */
class `Partition List` {

    fun partition(head: ListNode?, x: Int): ListNode? {

        var frontListHead: ListNode? = null
        var frontListEnd: ListNode? = null

        var backListHead: ListNode? = null
        var backListEnd: ListNode? = null

        var mainPointer: ListNode? = head

        while (mainPointer != null) {
            if (mainPointer.`val` < x) {
                if (frontListHead == null) {
                    frontListHead = mainPointer
                }  else {
                    frontListEnd?.next = mainPointer
                }
                frontListEnd = mainPointer

            } else {
                if (backListHead == null) {
                    backListHead = mainPointer
                }  else {
                    backListEnd?.next = mainPointer
                }
                backListEnd = mainPointer

            }
            mainPointer = mainPointer.next

        }

        frontListEnd?.let { it.next =  backListHead}
        backListEnd?.let { it.next = null }
        return frontListHead ?: backListHead
    }
}